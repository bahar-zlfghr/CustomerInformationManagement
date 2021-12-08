package com.dotin.exception;

import com.dotin.model.CustomerFactory;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.IndividualCustomer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Bahar Zolfaghari
 **/
@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = DuplicateIndividualCustomerException.class)
    public ModelAndView duplicateCustomerException(DuplicateIndividualCustomerException e) {
        ModelAndView modelAndView = new ModelAndView();
        IndividualCustomer individualCustomer = (IndividualCustomer) CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
        modelAndView.addObject("duplicateIndividualCustomerException", e.getMessage());
        modelAndView.addObject("individualCustomer", individualCustomer);
        modelAndView.setViewName("individual-customer-registration");
        return modelAndView;
    }
}
