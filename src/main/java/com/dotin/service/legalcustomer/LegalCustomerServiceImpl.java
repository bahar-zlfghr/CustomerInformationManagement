package com.dotin.service.legalcustomer;

import com.dotin.exception.DuplicateLegalCustomerException;
import com.dotin.model.data.Customer;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.LegalCustomer;
import com.dotin.model.repository.LegalCustomerRepository;
import com.dotin.service.component.MessageSourceComponent;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
public class LegalCustomerServiceImpl implements LegalCustomerService {
    private final LegalCustomerRepository legalCustomerRepository;
    private final MessageSourceComponent messageSourceComponent;

    public LegalCustomerServiceImpl(LegalCustomerRepository legalCustomerRepository, MessageSourceComponent messageSourceComponent) {
        this.legalCustomerRepository = legalCustomerRepository;
        this.messageSourceComponent = messageSourceComponent;
    }

    @Override
    public LegalCustomer saveLegalCustomer(LegalCustomer legalCustomer) {
        Optional<Customer> existingLegalCustomer = legalCustomerRepository.findByEconomicCode(legalCustomer.getEconomicCode());
        if (existingLegalCustomer.isPresent()) {
            throw new DuplicateLegalCustomerException(
                    messageSourceComponent.getPersian(
                            "legal.customer.economicCode.duplicated", legalCustomer.getEconomicCode()));
        }
        legalCustomer.setCustomerType(CustomerType.LEGAL.getCustomerType());
        return legalCustomerRepository.save(legalCustomer);
    }
}
