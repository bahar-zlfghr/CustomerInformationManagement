package com.dotin.controller;

import com.dotin.model.CustomerFactory;
import com.dotin.model.data.CustomerType;
import com.dotin.model.data.LegalCustomer;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.legalcustomer.LegalCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class LegalCustomerController {
    private final LegalCustomerService legalCustomerService;
    private final MessageSourceComponent messageSourceComponent;

    public LegalCustomerController(LegalCustomerService legalCustomerService, MessageSourceComponent messageSourceComponent) {
        this.legalCustomerService = legalCustomerService;
        this.messageSourceComponent = messageSourceComponent;
    }

    @GetMapping(value = "/save-legal-customer")
    public String getLegalCustomerRegistrationForm(Model model) {
        LegalCustomer legalCustomer = (LegalCustomer) CustomerFactory.createCustomer(CustomerType.LEGAL);
        model.addAttribute("legalCustomer", legalCustomer);
        return "legal-customer-registration";
    }

    @PostMapping(value = "/save-legal-customer")
    public String saveLegalCustomer(@ModelAttribute LegalCustomer legalCustomer, HttpSession httpSession,
                                    BindingResult bindingResult) {
        LegalCustomer registeredLegalCustomer = legalCustomerService.saveLegalCustomer(legalCustomer);
        String economicCode = registeredLegalCustomer.getEconomicCode();
        httpSession.setAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.successfully.registered", economicCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.customerNumber.generated",
                        economicCode, String.valueOf(registeredLegalCustomer.getCustomerNO())));
        return "redirect:http://localhost:8080/";
    }

    @GetMapping(value = "/delete-legal-customer/{customerNO}")
    public String deleteLegalCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        legalCustomerService.deleteLegalCustomer(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteLegalCustomerSuccessMessage",
                messageSourceComponent.getPersian("legal.customer.successfully.deleted", customerNO));
        return "redirect:http://localhost:8080/customers";
    }
}
