package com.dotin.exception;

import com.dotin.util.CustomerDtoUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author : Bahar Zolfaghari
 **/
@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = DuplicateRealCustomerException.class)
    public ModelAndView duplicateIndividualCustomerException(DuplicateRealCustomerException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("duplicateRealCustomerException", e.getMessage());
        modelAndView.addObject("realCustomer", CustomerDtoUtil.createRealCustomer());
        modelAndView.setViewName("real-customer-registration");
        return modelAndView;
    }

    @ExceptionHandler(value = DuplicateLegalCustomerException.class)
    public ModelAndView duplicateLegalCustomerException(DuplicateLegalCustomerException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("duplicateLegalCustomerException", e.getMessage());
        modelAndView.addObject("legalCustomer", CustomerDtoUtil.createLegalCustomer());
        modelAndView.setViewName("legal-customer-registration");
        return modelAndView;
    }

    @ExceptionHandler(value = RealCustomerNotFoundException.class)
    public String realCustomerNotFoundException(RealCustomerNotFoundException e, HttpSession httpSession) {
        httpSession.setAttribute("realCustomerNotFoundException", e.getMessage());
        return "redirect:http://localhost:8080/customers";
    }

    @ExceptionHandler(value = LegalCustomerNotFoundException.class)
    public String legalCustomerNotFoundException(LegalCustomerNotFoundException e, HttpSession httpSession) {
        httpSession.setAttribute("legalCustomerNotFoundException", e.getMessage());
        return "redirect:http://localhost:8080/customers";
    }
}
