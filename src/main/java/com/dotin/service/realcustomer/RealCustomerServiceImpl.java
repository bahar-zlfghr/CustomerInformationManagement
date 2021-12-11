package com.dotin.service.realcustomer;

import com.dotin.dto.RealCustomerDto;
import com.dotin.exception.DuplicateRealCustomerException;
import com.dotin.exception.RealCustomerNotFoundException;
import com.dotin.mapper.realcustomer.RealCustomerMapper;
import com.dotin.model.data.RealCustomer;
import com.dotin.model.repository.RealCustomerRepository;
import com.dotin.service.component.MessageSourceComponent;
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
    public RealCustomerDto saveRealCustomer(RealCustomerDto realCustomerDto) throws DuplicateRealCustomerException {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCode(realCustomerDto.getNationalCode());
        if (existingRealCustomer.isPresent()) {
            throw new DuplicateRealCustomerException(
                    messageSourceComponent.getPersian(
                            "real.customer.nationalCode.duplicated",
                            realCustomerDto.getNationalCode()));
        }
        return realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
    }

    @Override
    public List<RealCustomerDto> findAllRealCustomers() {
        return realCustomerRepository.findAll().stream()
                .map(realCustomerMapper::toRealCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRealCustomer(Integer customerNO) {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCustomerNO(customerNO);
        realCustomerRepository.delete(existingRealCustomer
                .orElseThrow(() -> new RealCustomerNotFoundException(
                        messageSourceComponent.getPersian("real.customer.not.found", String.valueOf(customerNO)))));
    }

    @Override
    public RealCustomerDto findRealCustomerByCustomerNO(Integer customerNO) {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCustomerNO(customerNO);
        return realCustomerMapper.toRealCustomerDto(
                existingRealCustomer.orElseThrow(() -> new RealCustomerNotFoundException(
                        messageSourceComponent.getPersian("real.customer.not.found", String.valueOf(customerNO)))));
    }

    @Override
    public void updateRealCustomer(RealCustomerDto realCustomerDto) {
        realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
    }
}
