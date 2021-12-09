package com.dotin.service.individualcustomer;

import com.dotin.exception.CustomerNotFoundException;
import com.dotin.exception.DuplicateIndividualCustomerException;
import com.dotin.util.CustomerUpdater;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.IndividualCustomer;
import com.dotin.model.repository.IndividualCustomerRepository;
import com.dotin.service.component.MessageSourceComponent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
public class IndividualIndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final MessageSourceComponent messageSourceComponent;

    public IndividualIndividualCustomerServiceImpl(IndividualCustomerRepository individualCustomerRepository, MessageSourceComponent messageSourceComponent) {
        this.individualCustomerRepository = individualCustomerRepository;
        this.messageSourceComponent = messageSourceComponent;
    }

    @Override
    public IndividualCustomer saveIndividualCustomer(IndividualCustomer individualCustomer) throws DuplicateIndividualCustomerException {
        Optional<IndividualCustomer> existingIndividualCustomer = individualCustomerRepository.findByNationalCode(individualCustomer.getNationalCode());
        if (existingIndividualCustomer.isPresent()) {
            throw new DuplicateIndividualCustomerException(
                    messageSourceComponent.getPersian(
                            "individual.customer.nationalCode.duplicated",
                            individualCustomer.getNationalCode()));
        }
        individualCustomer.setCustomerType(CustomerType.INDIVIDUAL.getCustomerType());
        return individualCustomerRepository.save(individualCustomer);
    }

    @Override
    public List<IndividualCustomer> findAllIndividualCustomers() {
        return individualCustomerRepository.findAll();
    }

    @Override
    public void deleteIndividualCustomer(Integer customerNO) {
        Optional<IndividualCustomer> existingIndividualCustomer = individualCustomerRepository.findByCustomerNO(customerNO);
        individualCustomerRepository.delete(existingIndividualCustomer
                .orElseThrow(() -> new CustomerNotFoundException(
                        messageSourceComponent.getPersian("individual.customer.not.found", String.valueOf(customerNO)))));
    }

    @Override
    public IndividualCustomer findIndividualCustomerByCustomerNO(Integer customerNO) {
        Optional<IndividualCustomer> existingIndividualCustomer = individualCustomerRepository.findByCustomerNO(customerNO);
        return existingIndividualCustomer
                .orElseThrow(() -> new CustomerNotFoundException(
                        messageSourceComponent.getPersian("individual.customer.not.found", String.valueOf(customerNO))));
    }

    @Override
    public IndividualCustomer updateIndividualCustomer(IndividualCustomer individualCustomer) {
        Optional<IndividualCustomer> existingIndividualCustomer =
                individualCustomerRepository.findByNationalCode(individualCustomer.getNationalCode());
        IndividualCustomer updatingIndividualCustomer = existingIndividualCustomer.orElseThrow(() -> new CustomerNotFoundException(
                messageSourceComponent.getPersian("individual.customer.not.found")));
        CustomerUpdater.updateIndividualCustomer(updatingIndividualCustomer, individualCustomer);
        return individualCustomerRepository.save(updatingIndividualCustomer);
    }
}
