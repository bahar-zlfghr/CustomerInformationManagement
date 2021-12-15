package com.dotin.service.realcustomer;

import com.dotin.dto.RealCustomerDto;
import com.dotin.exception.DuplicateRealCustomerException;
import com.dotin.exception.NationalCodeDuplicatedException;
import com.dotin.exception.RealCustomerNotFoundException;
import com.dotin.mapper.realcustomer.RealCustomerMapper;
import com.dotin.model.data.RealCustomer;
import com.dotin.model.repository.RealCustomerRepository;
import com.dotin.model.repository.RealCustomerSpecification;
import com.dotin.service.component.MessageSourceComponent;
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
    public List<RealCustomerDto> findAllRealCustomers(String firstName, String lastName, String nationalCode, String customerNO) {
        return realCustomerRepository.findAll(Specification
                .where(RealCustomerSpecification.search(firstName, lastName, nationalCode, customerNO)))
                .stream()
                .map(realCustomerMapper::toRealCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRealCustomer(Integer customerNO) {
        RealCustomerDto realCustomerDto = findRealCustomerByCustomerNO(customerNO);
        realCustomerRepository.delete(realCustomerMapper.toRealCustomer(realCustomerDto));
    }

    @Override
    public RealCustomerDto findRealCustomerByCustomerNO(Integer customerNO) {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCustomerNO(customerNO);
        return realCustomerMapper.toRealCustomerDto(
                existingRealCustomer.orElseThrow(() -> new RealCustomerNotFoundException(
                        messageSourceComponent.getPersian("real.customer.not.found", String.valueOf(customerNO)))));
    }

    @Override
    public void updateRealCustomer(RealCustomerDto realCustomerDto) throws NationalCodeDuplicatedException {
        Optional<RealCustomer> existingRealCustomer = realCustomerRepository.findByCode(realCustomerDto.getNationalCode());
        if (existingRealCustomer.isPresent()) {
            RealCustomer realCustomer = existingRealCustomer.get();
            if (!realCustomer.getCustomerNO().equals(realCustomerDto.getCustomerNO())) {
                throw new NationalCodeDuplicatedException(
                        messageSourceComponent.getPersian("real.customer.nationalCode.duplicated", realCustomerDto.getNationalCode()));
            }
        }
        realCustomerMapper.toRealCustomerDto(
                realCustomerRepository.save(realCustomerMapper.toRealCustomer(realCustomerDto)));
    }
}
