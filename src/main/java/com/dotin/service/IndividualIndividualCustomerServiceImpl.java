package com.dotin.service;

import com.dotin.exception.DuplicateIndividualCustomerException;
import com.dotin.model.data.Customer;
import com.dotin.model.data.IndividualCustomer;
import com.dotin.model.repository.IndividualCustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
public class IndividualIndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository customerRepository;

    public IndividualIndividualCustomerServiceImpl(IndividualCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(IndividualCustomer individualCustomer) throws DuplicateIndividualCustomerException {
        Optional<Customer> existingIndividualCustomer = customerRepository.findByNationalCode(individualCustomer.getNationalCode());
        if (existingIndividualCustomer.isPresent()) {
            throw new DuplicateIndividualCustomerException("DuplicateIndividualCustomerException", individualCustomer);
        }
        System.out.println(individualCustomer.getCustomerType());
        customerRepository.save(individualCustomer);
    }
}
