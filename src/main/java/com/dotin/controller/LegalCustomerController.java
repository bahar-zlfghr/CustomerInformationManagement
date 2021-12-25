package com.dotin.controller;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateEconomicCodeException;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.component.PropertyReaderComponent;
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

    @PostMapping(value = "/save-legal-customer")
    public String saveLegalCustomer(@ModelAttribute CustomerDto legalCustomer, HttpSession httpSession,
                                    BindingResult bindingResult) {
        CustomerDto registeredLegalCustomer = legalCustomerService.saveLegalCustomer(legalCustomer);
        String economicCode = registeredLegalCustomer.getCode();
        httpSession.setAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.successfully.registered", economicCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.customerNumber.generated",
                        economicCode, String.valueOf(registeredLegalCustomer.getCustomerNO())));
        return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/";
    }

    @GetMapping(value = "/update-legal-customer/{customerNO}")
    public String getLegalCustomerUpdateForm(@PathVariable String customerNO, Model model) {
        CustomerDto legalCustomer =
                legalCustomerService.findLegalCustomerByCustomerNO(Integer.valueOf(customerNO));
        model.addAttribute("legalCustomer", legalCustomer);
        return "legal-customer-update";
    }

    @PostMapping(value = "/update-legal-customer")
    public String updateLegalCustomer(@ModelAttribute CustomerDto legalCustomer, HttpSession httpSession) {
        try {
            legalCustomerService.updateLegalCustomer(legalCustomer);
            httpSession.setAttribute("updateLegalCustomerSuccessMessage",
                    messageSourceComponent.getPersian(
                            "legal.customer.successfully.updated", String.valueOf(legalCustomer.getCustomerNO())));
            return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/customers";
        } catch (DuplicateEconomicCodeException e) {
            httpSession.setAttribute("duplicateEconomicCodeException", e.getMessage());
            return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/update-legal-customer/" + legalCustomer.getCustomerNO();
        }
    }

    @GetMapping(value = "/delete-legal-customer/{customerNO}")
    public String deleteLegalCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        legalCustomerService.deleteLegalCustomer(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteLegalCustomerSuccessMessage",
                messageSourceComponent.getPersian("legal.customer.successfully.deleted", customerNO));
        return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/customers";
    }
}
