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

    public RealCustomerServiceImpl(RealCustomerRepository realCustomerRepository, 
                                   MessageSourceComponent messageSourceComponent, 
                                   RealCustomerMapper realCustomerMapper) {
        this.realCustomerRepository = realCustomerRepository;
        this.messageSourceComponent = messageSourceComponent;
        this.realCustomerMapper = realCustomerMapper;
    }

    @Override
    public CustomerDto saveRealCustomer(CustomerDto realCustomerDto) throws DuplicateRealCustomerException {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCode(realCustomerDto.getCode());
        if (!RealCustomerValidator.validateRealCustomerForSaveOperation(existingRealCustomer)) {
            throw new DuplicateRealCustomerException(
                    messageSourceComponent.getPersian(
                            "real.customer.nationalCode.duplicated",
                            realCustomerDto.getCode()));
        }
        return realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
    }

    @Override
    public List<CustomerDto> findAllRealCustomers(String firstName, String lastName, String nationalCode, String customerNO) {
        return realCustomerRepository.findAll(Specification
                .where(RealCustomerSpecification.search(firstName, lastName, nationalCode, customerNO)))
                .stream()
                .map(realCustomerMapper::toRealCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRealCustomer(Integer customerNO) {
        CustomerDto realCustomerDto = findRealCustomerByCustomerNO(customerNO);
        realCustomerRepository.delete(realCustomerMapper.toRealCustomer(realCustomerDto));
    }

    @Override
    public CustomerDto findRealCustomerByCustomerNO(Integer customerNO) {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCustomerNO(customerNO);
        return realCustomerMapper.toRealCustomerDto(
                existingRealCustomer.orElseThrow(() -> new RealCustomerNotFoundException(
                        messageSourceComponent.getPersian("real.customer.not.found", String.valueOf(customerNO)))));
    }

    @Override
    public void updateRealCustomer(CustomerDto realCustomerDto) throws DuplicateNationalCodeException {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCode(realCustomerDto.getCode());
        if (!RealCustomerValidator.validateRealCustomerForUpdateOperation(existingRealCustomer, realCustomerDto)) {
                throw new DuplicateNationalCodeException(
                        messageSourceComponent.getPersian("real.customer.nationalCode.duplicated", realCustomerDto.getCode()));
        }
        realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
    }
}
