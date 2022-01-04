package com.dotin.controller;

import com.dotin.configuration.property.CustomerProperties;
import com.dotin.dto.CustomerDto;
import com.dotin.service.legalcustomer.LegalCustomerService;
import com.dotin.service.realcustomer.RealCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class CustomerController {
    private final RealCustomerService realCustomerService;
    private final LegalCustomerService legalCustomerService;

    public CustomerController(RealCustomerService realCustomerService, LegalCustomerService legalCustomerService) {
        this.realCustomerService = realCustomerService;
        this.legalCustomerService = legalCustomerService;
    }

    @GetMapping(value = "/customers")
    public String getCustomers(@RequestParam(required = false, name = "customerNO") String customerNO,
                               @RequestParam(required = false, name = "customerType") String customerType,
                               @RequestParam(required = false, name = "name") String name,
                               @RequestParam(required = false, name = "lastName") String lastName,
                               @RequestParam(required = false, name = "code") String code,
                               HttpSession httpSession,
                               Model model) {
        httpSession.setAttribute("real", CustomerProperties.REAL_TEXT);
        httpSession.setAttribute("legal", CustomerProperties.LEGAL_TEXT);
        List<CustomerDto> customers = new ArrayList<>();
        List<CustomerDto> realCustomers = realCustomerService.findAllRealCustomers(name, lastName, code, customerNO);
        List<CustomerDto> legalCustomers = legalCustomerService.findAllLegalCustomers(name, code, customerNO);
        if (!Objects.isNull(customerType) && customerType.equals("0")) {
            customers.addAll(realCustomers);
        }
        else if (!Objects.isNull(customerType) && customerType.equals("1")) {
            customers.addAll(legalCustomers);
        }
        else {
            customers.addAll(realCustomers);
            customers.addAll(legalCustomers);
        }
        model.addAttribute("customers", customers);
        return "customers-list";
    }

    @GetMapping(value = "/save-customer")
    public String getCustomerRegistrationForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "customer-registration";
    }
}
