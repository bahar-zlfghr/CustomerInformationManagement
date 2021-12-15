package com.dotin.service.legalcustomer;

import com.dotin.dto.LegalCustomerDto;
import com.dotin.exception.DuplicateEconomicCodeException;
import com.dotin.exception.LegalCustomerNotFoundException;
import com.dotin.exception.DuplicateLegalCustomerException;
import com.dotin.mapper.legalcustomer.LegalCustomerMapper;
import com.dotin.model.data.LegalCustomer;
import com.dotin.model.repository.LegalCustomerRepository;
import com.dotin.model.repository.LegalCustomerSpecification;
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
public class LegalCustomerServiceImpl implements LegalCustomerService {
    private final LegalCustomerRepository legalCustomerRepository;
    private final MessageSourceComponent messageSourceComponent;
    private final LegalCustomerMapper legalCustomerMapper;

    public LegalCustomerServiceImpl(LegalCustomerRepository legalCustomerRepository, MessageSourceComponent messageSourceComponent, LegalCustomerMapper legalCustomerMapper) {
        this.legalCustomerRepository = legalCustomerRepository;
        this.messageSourceComponent = messageSourceComponent;
        this.legalCustomerMapper = legalCustomerMapper;
    }

    @Override
    public LegalCustomerDto saveLegalCustomer(LegalCustomerDto legalCustomerDto) {
        Optional<LegalCustomer> existingLegalCustomer = legalCustomerRepository.findByCode(legalCustomerDto.getEconomicCode());
        if (existingLegalCustomer.isPresent()) {
            throw new DuplicateLegalCustomerException(
                    messageSourceComponent.getPersian(
                            "legal.customer.economicCode.duplicated", legalCustomerDto.getEconomicCode()));
        }
        return legalCustomerMapper.toLegalCustomerDto(
                legalCustomerRepository.save(legalCustomerMapper.toLegalCustomer(legalCustomerDto)));
    }

    @Override
    public List<LegalCustomerDto> findAllLegalCustomers(String companyName, String economicCode, String customerNO) {
        return legalCustomerRepository.findAll(Specification
                .where(LegalCustomerSpecification.search(companyName, economicCode, customerNO)))
                .stream()
                .map(legalCustomerMapper::toLegalCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLegalCustomerDto(Integer customerNO) {
        LegalCustomerDto legalCustomerDto = findLegalCustomerDtoByCustomerNO(customerNO);
        legalCustomerRepository.delete(legalCustomerMapper.toLegalCustomer(legalCustomerDto));
    }

    @Override
    public LegalCustomerDto findLegalCustomerDtoByCustomerNO(Integer customerNO) {
        Optional<LegalCustomer> existingLegalCustomer = legalCustomerRepository.findByCustomerNO(customerNO);
        return legalCustomerMapper.toLegalCustomerDto(
                existingLegalCustomer.orElseThrow(() -> new LegalCustomerNotFoundException(
                        messageSourceComponent.getPersian("legal.customer.not.found", String.valueOf(customerNO)))));
    }

    @Override
    public void updateLegalCustomerDto(LegalCustomerDto legalCustomerDto) throws DuplicateEconomicCodeException {
        Optional<LegalCustomer> existingLegalCustomer = legalCustomerRepository.findByCode(legalCustomerDto.getEconomicCode());
        if (existingLegalCustomer.isPresent()) {
            LegalCustomer legalCustomer = existingLegalCustomer.get();
            if (!legalCustomer.getCustomerNO().equals(legalCustomerDto.getCustomerNO())) {
                throw new DuplicateEconomicCodeException(
                  messageSourceComponent.getPersian("legal.customer.economicCode.duplicated", legalCustomerDto.getEconomicCode()));
            }
        }
        legalCustomerMapper.toLegalCustomerDto(
                legalCustomerRepository.save(legalCustomerMapper.toLegalCustomer(legalCustomerDto)));
    }
}
