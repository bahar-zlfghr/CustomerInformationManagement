package com.dotin.controller;

import com.dotin.service.realcustomer.RealCustomerService;
import com.dotin.service.legalcustomer.LegalCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class MainController {
    private final RealCustomerService realCustomerService;
    private final LegalCustomerService legalCustomerService;

    public MainController(RealCustomerService realCustomerService, LegalCustomerService legalCustomerService) {
        this.realCustomerService = realCustomerService;
        this.legalCustomerService = legalCustomerService;
    }

    @GetMapping(value = "/customers")
    public String viewCustomersListPage(Model model) {
        model.addAttribute("realCustomers", realCustomerService.findAllRealCustomers());
        model.addAttribute("legalCustomers", legalCustomerService.findAllLegalCustomers());
        return "customers-list";
    }
}
