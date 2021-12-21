package com.dotin.controller;

import com.dotin.dto.LegalCustomerDto;
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
    private final PropertyReaderComponent propertyReaderComponent;

    public LegalCustomerController(LegalCustomerService legalCustomerService, MessageSourceComponent messageSourceComponent,
                                   PropertyReaderComponent propertyReaderComponent) {
        this.legalCustomerService = legalCustomerService;
        this.messageSourceComponent = messageSourceComponent;
        this.propertyReaderComponent = propertyReaderComponent;
    }

    @GetMapping(value = "/legal-customers")
    public String saveLegalCustomer(@RequestParam(required = false, name = "companyName") String companyName,
                                    @RequestParam(required = false, name = "economicCode") String economicCode,
                                    @RequestParam(required = false, name = "customerNO") String customerNO,
                                    Model model) {
        model.addAttribute("legalCustomers",
                legalCustomerService.findAllLegalCustomers(companyName, economicCode, customerNO));
        return "legal-customers-list";
    }

    @GetMapping(value = "/save-legal-customer")
    public String getLegalCustomerRegistrationForm(Model model) {
        LegalCustomerDto legalCustomer = new LegalCustomerDto();
        model.addAttribute("legalCustomer", legalCustomer);
        return "legal-customer-registration";
    }

    @PostMapping(value = "/save-legal-customer")
    public String saveLegalCustomer(@ModelAttribute LegalCustomerDto legalCustomer, HttpSession httpSession,
                                    BindingResult bindingResult) {
        LegalCustomerDto registeredLegalCustomer = legalCustomerService.saveLegalCustomer(legalCustomer);
        String economicCode = registeredLegalCustomer.getEconomicCode();
        httpSession.setAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.successfully.registered", economicCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.customerNumber.generated",
                        economicCode, String.valueOf(registeredLegalCustomer.getCustomerNO())));
        return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/";
    }

    @GetMapping(value = "/update-legal-customer/{customerNO}")
    public String getLegalCustomerUpdatationForm(@PathVariable String customerNO, Model model) {
        LegalCustomerDto legalCustomer =
                legalCustomerService.findLegalCustomerDtoByCustomerNO(Integer.valueOf(customerNO));
        model.addAttribute("legalCustomer", legalCustomer);
        return "legal-customer-updatation";
    }

    @PostMapping(value = "/update-legal-customer")
    public String updateLegalCustomer(@ModelAttribute LegalCustomerDto legalCustomer, HttpSession httpSession) {
        try {
            legalCustomerService.updateLegalCustomerDto(legalCustomer);
            httpSession.setAttribute("updateLegalCustomerSuccessMessage",
                    messageSourceComponent.getPersian(
                            "legal.customer.successfully.updated", String.valueOf(legalCustomer.getCustomerNO())));
            return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/legal-customers";
        } catch (DuplicateEconomicCodeException e) {
            httpSession.setAttribute("duplicateEconomicCodeException", e.getMessage());
            return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/update-legal-customer/" + legalCustomer.getCustomerNO();
        }
    }

    @GetMapping(value = "/delete-legal-customer/{customerNO}")
    public String deleteLegalCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        legalCustomerService.deleteLegalCustomerDto(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteLegalCustomerSuccessMessage",
                messageSourceComponent.getPersian("legal.customer.successfully.deleted", customerNO));
        return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/legal-customers";
    }
}
