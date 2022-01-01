package com.dotin.service.realcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateRealCustomerException;
import com.dotin.exception.DuplicateNationalCodeException;
import com.dotin.exception.RealCustomerNotFoundException;
import com.dotin.mapper.realcustomer.RealCustomerMapper;
import com.dotin.model.data.RealCustomer;
import com.dotin.model.repository.RealCustomerRepository;
import com.dotin.model.repository.RealCustomerSpecification;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.validator.RealCustomerValidator;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
@Transactional
public class RealCustomerServiceImpl implements RealCustomerService {
    private final RealCustomerRepository realCustomerRepository;
    private final MessageSourceComponent messageSourceComponent;
    private final RealCustomerMapper realCustomerMapper;
    private final Logger logger = Logger.getLogger(RealCustomerServiceImpl.class);

    public RealCustomerServiceImpl(RealCustomerRepository realCustomerRepository, 
                                   MessageSourceComponent messageSourceComponent, 
                                   RealCustomerMapper realCustomerMapper) {
        this.realCustomerRepository = realCustomerRepository;
        this.messageSourceComponent = messageSourceComponent;
        this.realCustomerMapper = realCustomerMapper;
    }

    @Override
    public CustomerDto saveRealCustomer(CustomerDto realCustomerDto) throws DuplicateRealCustomerException {
        logger.info("Real customer information is being stored...");
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCode(realCustomerDto.getCode());
        if (!RealCustomerValidator.validateRealCustomerForSaveOperation(existingRealCustomer)) {
            DuplicateRealCustomerException duplicateRealCustomerException = new DuplicateRealCustomerException(
                    messageSourceComponent.getPersian(
                            "real.customer.nationalCode.duplicated",
                            realCustomerDto.getCode()));
            logger.error("Real customer information with national code '" +
                    realCustomerDto.getCode() + "' was duplicated!", duplicateRealCustomerException);
            throw duplicateRealCustomerException;
        }
        logger.info("Real customer information with national code '" +
                realCustomerDto.getCode() + "' was successfully saved.");
        return realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
    }

    @Override
    public List<CustomerDto> findAllRealCustomers(String firstName, String lastName, String nationalCode, String customerNO) {
        logger.info("Real customers information is being fetched...");
        List<CustomerDto> realCustomers = realCustomerRepository.findAll(Specification
                .where(RealCustomerSpecification.search(firstName, lastName, nationalCode, customerNO)))
                .stream()
                .map(realCustomerMapper::toRealCustomerDto)
                .collect(Collectors.toList());
        logger.info("All real customers information was successfully found.");
        return realCustomers;
    }

    @Override
    public void deleteRealCustomer(Integer customerNO) {
        logger.info("Real customer information is being removed by customer number...");
        CustomerDto realCustomerDto = findRealCustomerByCustomerNO(customerNO);
        realCustomerRepository.delete(realCustomerMapper.toRealCustomer(realCustomerDto));
        logger.info("Real customer with national code '" + realCustomerDto.getCode() + "' was successfully removed.");
    }

    @Override
    public CustomerDto findRealCustomerByCustomerNO(Integer customerNO) {
        logger.info("Real customer information is being found by customer number...");
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCustomerNO(customerNO);
        CustomerDto customerDto = realCustomerMapper.toRealCustomerDto(
                existingRealCustomer.orElseThrow(() -> {
                    RealCustomerNotFoundException realCustomerNotFoundException = new RealCustomerNotFoundException(
                            messageSourceComponent.getPersian("real.customer.not.found", String.valueOf(customerNO)));
                    logger.error("There is no real customer with customer number '" + customerNO + "'!", realCustomerNotFoundException);
                    return realCustomerNotFoundException;
                })
        );
        logger.info("Real customer with customer number '" + customerNO + "' was successfully found.");
        return customerDto;
    }

    @Override
    public void updateRealCustomer(CustomerDto realCustomerDto) throws DuplicateNationalCodeException {
        logger.info("Real customer information is being updated...");
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCode(realCustomerDto.getCode());
        if (!RealCustomerValidator.validateRealCustomerForUpdateOperation(existingRealCustomer, realCustomerDto)) {
            DuplicateNationalCodeException duplicateNationalCodeException = new DuplicateNationalCodeException(
                    messageSourceComponent.getPersian("real.customer.nationalCode.duplicated", realCustomerDto.getCode()));
            logger.error("National code '" + realCustomerDto.getCode() + "' belongs to another real customer!",
                    duplicateNationalCodeException);
            throw duplicateNationalCodeException;
        }
        realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
        logger.info("Real customer information was successfully updated");
    }
}
