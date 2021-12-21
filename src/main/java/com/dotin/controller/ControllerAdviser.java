package com.dotin.controller;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateLegalCustomerException;
import com.dotin.exception.DuplicateRealCustomerException;
import com.dotin.exception.LegalCustomerNotFoundException;
import com.dotin.exception.RealCustomerNotFoundException;
import com.dotin.service.component.PropertyReaderComponent;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author : Bahar Zolfaghari
 **/
@ControllerAdvice
public class ControllerAdviser {
    private final PropertyReaderComponent propertyReaderComponent;

    public ControllerAdviser(PropertyReaderComponent propertyReaderComponent) {
        this.propertyReaderComponent = propertyReaderComponent;
    }

    @ExceptionHandler(value = DuplicateRealCustomerException.class)
    public ModelAndView duplicateIndividualCustomerException(DuplicateRealCustomerException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("duplicateRealCustomerException", e.getMessage());
        modelAndView.addObject("customer", new CustomerDto());
        modelAndView.setViewName("customer-registration");
        return modelAndView;
    }

    @ExceptionHandler(value = DuplicateLegalCustomerException.class)
    public ModelAndView duplicateLegalCustomerException(DuplicateLegalCustomerException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("duplicateLegalCustomerException", e.getMessage());
        modelAndView.addObject("customer", new CustomerDto());
        modelAndView.setViewName("customer-registration");
        return modelAndView;
    }

    @ExceptionHandler(value = RealCustomerNotFoundException.class)
    public String realCustomerNotFoundException(RealCustomerNotFoundException e, HttpSession httpSession) {
        httpSession.setAttribute("realCustomerNotFoundException", e.getMessage());
        return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/real-customers";
    }

    @ExceptionHandler(value = LegalCustomerNotFoundException.class)
    public String legalCustomerNotFoundException(LegalCustomerNotFoundException e, HttpSession httpSession) {
        httpSession.setAttribute("legalCustomerNotFoundException", e.getMessage());
        return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/legal-customers";
    }
}
