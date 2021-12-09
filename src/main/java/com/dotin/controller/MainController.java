package com.dotin.controller;

import com.dotin.service.individualcustomer.IndividualCustomerService;
import com.dotin.service.legalcustomer.LegalCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class MainController {
    private final IndividualCustomerService individualCustomerService;
    private final LegalCustomerService legalCustomerService;

    public MainController(IndividualCustomerService individualCustomerService, LegalCustomerService legalCustomerService) {
        this.individualCustomerService = individualCustomerService;
        this.legalCustomerService = legalCustomerService;
    }

    @GetMapping(value = "/customers")
    public String viewCustomersListPage(Model model) {
        model.addAttribute("individualCustomers", individualCustomerService.findAllIndividualCustomers());
        model.addAttribute("legalCustomers", legalCustomerService.findAllLegalCustomers());
        return "customers-list";
    }
}
