package com.dotin.controller;

import com.dotin.dto.RealCustomerDto;
import com.dotin.service.realcustomer.RealCustomerService;
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
public class RealCustomerController {
    private final RealCustomerService realCustomerService;
    private final MessageSourceComponent messageSourceComponent;

    public RealCustomerController(RealCustomerService realCustomerService, 
                                  MessageSourceComponent messageSourceComponent) {
        this.realCustomerService = realCustomerService;
        this.messageSourceComponent = messageSourceComponent;
    }

    @GetMapping(value = "/real-customers")
    public String getRealCustomers(Model model) {
        model.addAttribute("realCustomers", realCustomerService.findAllRealCustomers());
        return "real-customers-list";
    }

    @GetMapping(value = "/save-real-customer")
    public String getRealCustomerRegistrationForm(Model model) {
        model.addAttribute("realCustomer", new RealCustomerDto());
        return "real-customer-registration";
    }

    @PostMapping(value = "/save-real-customer")
    public String updateRealCustomer(@ModelAttribute RealCustomerDto realCustomerDto, HttpSession httpSession,
                                           BindingResult bindingResult) {
        RealCustomerDto registeredRealCustomer = realCustomerService.saveRealCustomer(realCustomerDto);
        String nationalCode = registeredRealCustomer.getNationalCode();
        httpSession.setAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                "real.customer.successfully.registered", nationalCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian(
                        "real.customer.customerNumber.generated",
                        nationalCode, String.valueOf(registeredRealCustomer.getCustomerNO())));
        return "redirect:http://localhost:8080/";
    }

    @GetMapping(value = "/update-real-customer/{customerNO}")
    public String updateRealCustomer(@PathVariable String customerNO, Model model) {
        RealCustomerDto realCustomer =
                realCustomerService.findRealCustomerByCustomerNO(Integer.valueOf(customerNO));
        model.addAttribute("realCustomer", realCustomer);
        return "real-customer-updatation";
    }

    @PostMapping(value = "/update-real-customer")
    public String updateRealCustomer(@ModelAttribute RealCustomerDto realCustomer, HttpSession httpSession) {
        realCustomerService.updateRealCustomer(realCustomer);
        httpSession.setAttribute("updateRealCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                        "real.customer.successfully.updated", String.valueOf(realCustomer.getCustomerNO())));
        return "redirect:http://localhost:8080/customers";
    }

    @GetMapping(value = "/delete-real-customer/{customerNO}")
    public String deleteRealCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        realCustomerService.deleteRealCustomer(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteRealCustomerSuccessMessage",
                messageSourceComponent.getPersian("real.customer.successfully.deleted", customerNO));
        return "redirect:http://localhost:8080/customers";
    }
}
