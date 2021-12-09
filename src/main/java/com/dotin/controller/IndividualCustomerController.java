package com.dotin.controller;

import com.dotin.model.CustomerFactory;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.IndividualCustomer;
import com.dotin.service.individualcustomer.IndividualCustomerService;
import com.dotin.service.component.MessageSourceComponent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String saveIndividualCustomer(@ModelAttribute IndividualCustomer individualCustomer, HttpSession httpSession,
                                         BindingResult bindingResult) {
        IndividualCustomer registeredIndividualCustomer = individualCustomerService.saveIndividualCustomer(individualCustomer);
        String nationalCode = registeredIndividualCustomer.getNationalCode();
        httpSession.setAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                "individual.customer.successfully.registered", nationalCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian(
                        "individual.customer.customerNumber.generated",
                        nationalCode, String.valueOf(registeredIndividualCustomer.getCustomerNO())));
        return "redirect:http://localhost:8080/";
    }

    @GetMapping(value = "/delete-individual-customer/{customerNO}")
    public String deleteIndividualCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        individualCustomerService.deleteIndividualCustomer(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteIndividualCustomerSuccessMessage",
                messageSourceComponent.getPersian("individual.customer.successfully.deleted", customerNO));
        return "redirect:http://localhost:8080/customers";
    }
}
