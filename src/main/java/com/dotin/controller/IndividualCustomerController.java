package com.dotin.controller;

import com.dotin.model.CustomerFactory;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.IndividualCustomer;
import com.dotin.service.IndividualCustomerService;
import com.dotin.service.MessageSourceComponent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class IndividualCustomerController {
    private final IndividualCustomerService individualCustomerService;
    private final MessageSourceComponent messageSourceComponent;

    public IndividualCustomerController(IndividualCustomerService individualCustomerService,
                                        MessageSourceComponent messageSourceComponent) {
        this.individualCustomerService = individualCustomerService;
        this.messageSourceComponent = messageSourceComponent;
    }

    @GetMapping(value = "/save-individual-customer")
    public String getIndividualCustomerRegistrationForm(Model model) {
        IndividualCustomer individualCustomer = (IndividualCustomer) CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
        model.addAttribute("individualCustomer", individualCustomer);
        return "individual-customer-registration";
    }

    @PostMapping(value = "/save-individual-customer")
    public String saveIndividualCustomer(@ModelAttribute IndividualCustomer individualCustomer, Model model,
                                         HttpSession httpSession, BindingResult bindingResult) {
        IndividualCustomer registeredIndividualCustomer = individualCustomerService.saveIndividualCustomer(individualCustomer);
        String nationalCode = registeredIndividualCustomer.getNationalCode();
        model.addAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian("customer.successfully.registered", nationalCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian("customer.customerNumber.generated",
                        nationalCode, String.valueOf(registeredIndividualCustomer.getCustomerNO())));
        return "index";
    }
}
