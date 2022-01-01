package com.dotin.service.legalcustomer;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateEconomicCodeException;
import com.dotin.exception.LegalCustomerNotFoundException;
import com.dotin.exception.DuplicateLegalCustomerException;
import com.dotin.mapper.legalcustomer.LegalCustomerMapper;
import com.dotin.model.data.LegalCustomer;
import com.dotin.model.repository.LegalCustomerRepository;
import com.dotin.model.repository.LegalCustomerSpecification;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.validator.LegalCustomerValidator;
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
public class LegalCustomerServiceImpl implements LegalCustomerService {
    private final LegalCustomerRepository legalCustomerRepository;
    private final MessageSourceComponent messageSourceComponent;
    private final LegalCustomerMapper legalCustomerMapper;
    private final Logger logger = Logger.getLogger(LegalCustomerServiceImpl.class);

    public LegalCustomerServiceImpl(LegalCustomerRepository legalCustomerRepository, MessageSourceComponent messageSourceComponent, LegalCustomerMapper legalCustomerMapper) {
        this.legalCustomerRepository = legalCustomerRepository;
        this.messageSourceComponent = messageSourceComponent;
        this.legalCustomerMapper = legalCustomerMapper;
    }

    @Override
    public CustomerDto saveLegalCustomer(CustomerDto legalCustomerDto) {
        logger.info("Legal customer information is being stored...");
        Optional<LegalCustomer> existingLegalCustomer = legalCustomerRepository.findByCode(legalCustomerDto.getCode());
        if (!LegalCustomerValidator.validateLegalCustomerForSaveOperation(existingLegalCustomer)) {
            DuplicateLegalCustomerException duplicateLegalCustomerException = new DuplicateLegalCustomerException(
                    messageSourceComponent.getPersian(
                            "legal.customer.economicCode.duplicated", legalCustomerDto.getCode()));
            logger.error("Legal customer information with national code '" +
                    legalCustomerDto.getCode() + "' was duplicated!", duplicateLegalCustomerException);
            throw duplicateLegalCustomerException;
        }
        logger.info("Legal customer information with national code '" +
                legalCustomerDto.getCode() + "' was successfully saved.");
        return legalCustomerMapper.toLegalCustomerDto(
                legalCustomerRepository.save(legalCustomerMapper.toLegalCustomer(legalCustomerDto)));
    }

    @Override
    public List<CustomerDto> findAllLegalCustomers(String companyName, String economicCode, String customerNO) {
        logger.info("Legal customers information is being fetched...");
        List<CustomerDto> legalCustomers = legalCustomerRepository.findAll(Specification
                .where(LegalCustomerSpecification.search(companyName, economicCode, customerNO)))
                .stream()
                .map(legalCustomerMapper::toLegalCustomerDto)
                .collect(Collectors.toList());
        logger.info("All legal customers information was successfully found.");
        return legalCustomers;
    }

    @Override
    public void deleteLegalCustomer(Integer customerNO) {
        logger.info("Legal customer information is being removed by customer number...");
        CustomerDto legalCustomerDto = findLegalCustomerByCustomerNO(customerNO);
        legalCustomerRepository.delete(legalCustomerMapper.toLegalCustomer(legalCustomerDto));
        logger.info("Legal customer with national code '" + legalCustomerDto.getCode() + "' was successfully removed.");
    }

    @Override
    public CustomerDto findLegalCustomerByCustomerNO(Integer customerNO) {
        logger.info("Legal customer information is being found by customer number...");
        Optional<LegalCustomer> existingLegalCustomer = legalCustomerRepository.findByCustomerNO(customerNO);
        CustomerDto customerDto = legalCustomerMapper.toLegalCustomerDto(
                existingLegalCustomer.orElseThrow(() -> {
                    LegalCustomerNotFoundException legalCustomerNotFoundException = new LegalCustomerNotFoundException(
                            messageSourceComponent.getPersian("legal.customer.not.found", String.valueOf(customerNO)));
                    logger.error("There is no legal customer with customer number '" + customerNO + "'!", legalCustomerNotFoundException);
                    return legalCustomerNotFoundException;
                })
        );
        logger.info("Legal customer with customer number " + customerNO + " was successfully found.");
        return customerDto;
    }

    @Override
    public void updateLegalCustomer(CustomerDto legalCustomerDto) throws DuplicateEconomicCodeException {
        logger.info("Legal customer information is being updated...");
        Optional<LegalCustomer> existingLegalCustomer = legalCustomerRepository.findByCode(legalCustomerDto.getCode());
        if (!LegalCustomerValidator.validateLegalCustomerForUpdateOperation(existingLegalCustomer, legalCustomerDto)) {
            DuplicateEconomicCodeException duplicateEconomicCodeException = new DuplicateEconomicCodeException(
                    messageSourceComponent.getPersian("legal.customer.economicCode.duplicated", legalCustomerDto.getCode()));
            logger.error("National code '" + legalCustomerDto.getCode() + "' belongs to another legal customer!",
                    duplicateEconomicCodeException);
            throw duplicateEconomicCodeException;
        }
        legalCustomerMapper.toLegalCustomerDto(
                legalCustomerRepository.save(legalCustomerMapper.toLegalCustomer(legalCustomerDto)));
        logger.info("Legal customer information was successfully updated");
    }
}
