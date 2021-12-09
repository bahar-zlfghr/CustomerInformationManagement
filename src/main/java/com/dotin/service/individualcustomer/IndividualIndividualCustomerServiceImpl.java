package com.dotin.service.individualcustomer;

import com.dotin.exception.DuplicateIndividualCustomerException;
import com.dotin.model.data.Customer;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.IndividualCustomer;
import com.dotin.model.repository.IndividualCustomerRepository;
import com.dotin.service.component.MessageSourceComponent;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
public class IndividualIndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository customerRepository;
    private final MessageSourceComponent messageSourceComponent;

    public IndividualIndividualCustomerServiceImpl(IndividualCustomerRepository customerRepository, MessageSourceComponent messageSourceComponent) {
        this.customerRepository = customerRepository;
        this.messageSourceComponent = messageSourceComponent;
    }

    @Override
    public IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) throws DuplicateIndividualCustomerException {
        Optional<Customer> existingIndividualCustomer = customerRepository.findByNationalCode(individualCustomer.getNationalCode());
        if (existingIndividualCustomer.isPresent()) {
            throw new DuplicateIndividualCustomerException(
                    messageSourceComponent.getPersian(
                            "individual.customer.nationalCode.duplicated",
                            individualCustomer.getNationalCode()));
        }
        individualCustomer.setCustomerType(CustomerType.INDIVIDUAL.getCustomerType());
        return customerRepository.save(individualCustomer);
    }
}