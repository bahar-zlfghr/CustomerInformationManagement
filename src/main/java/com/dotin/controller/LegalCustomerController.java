package com.dotin.controller;

import com.dotin.dto.LegalCustomerDto;
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

    @GetMapping(value = "/legal-customers")
    public String viewCustomersListPage(Model model) {
        model.addAttribute("legalCustomers", legalCustomerService.findAllLegalCustomers());
        return "legal-customers-list";
    }

    @GetMapping(value = "/save-legal-customer")
    public String getLegalCustomers(Model model) {
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
        return "redirect:http://localhost:8080/";
    }

    @GetMapping(value = "/update-legal-customer/{customerNO}")
    public String updateLegalCustomer(@PathVariable String customerNO, Model model) {
        LegalCustomerDto legalCustomer =
                legalCustomerService.findLegalCustomerDtoByCustomerNO(Integer.valueOf(customerNO));
        model.addAttribute("legalCustomer", legalCustomer);
        return "legal-customer-updatation";
    }

    @PostMapping(value = "/update-legal-customer")
    public String updateLegalCustomer(@ModelAttribute LegalCustomerDto legalCustomer, HttpSession httpSession) {
        legalCustomerService.updateLegalCustomerDto(legalCustomer);
        httpSession.setAttribute("updateLegalCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                        "legal.customer.successfully.updated", String.valueOf(legalCustomer.getCustomerNO())));
        return "redirect:http://localhost:8080/customers";
    }

    @GetMapping(value = "/delete-legal-customer/{customerNO}")
    public String deleteLegalCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        legalCustomerService.deleteLegalCustomerDto(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteLegalCustomerSuccessMessage",
                messageSourceComponent.getPersian("legal.customer.successfully.deleted", customerNO));
        return "redirect:http://localhost:8080/customers";
    }
}
