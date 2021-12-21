package com.dotin.controller;

import com.dotin.dto.CustomerDto;
import com.dotin.exception.DuplicateNationalCodeException;
import com.dotin.service.component.PropertyReaderComponent;
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
    private final PropertyReaderComponent propertyReaderComponent;

    public RealCustomerController(RealCustomerService realCustomerService, MessageSourceComponent messageSourceComponent,
                                  PropertyReaderComponent propertyReaderComponent) {
        this.realCustomerService = realCustomerService;
        this.messageSourceComponent = messageSourceComponent;
        this.propertyReaderComponent = propertyReaderComponent;
    }

    @PostMapping(value = "/save-real-customer")
    public String saveRealCustomer(@ModelAttribute CustomerDto realCustomerDto, HttpSession httpSession,
                                     BindingResult bindingResult) {
        CustomerDto registeredRealCustomer = realCustomerService.saveRealCustomer(realCustomerDto);
        String nationalCode = registeredRealCustomer.getCode();
        httpSession.setAttribute("saveCustomerSuccessMessage",
                messageSourceComponent.getPersian(
                "real.customer.successfully.registered", nationalCode));
        httpSession.setAttribute("customerNumberMessage",
                messageSourceComponent.getPersian(
                        "real.customer.customerNumber.generated",
                        nationalCode, String.valueOf(registeredRealCustomer.getCustomerNO())));
        return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/";
    }

    @GetMapping(value = "/update-real-customer/{customerNO}")
    public String getRealCustomerUpdateForm(@PathVariable String customerNO, Model model) {
        CustomerDto realCustomer =
                realCustomerService.findRealCustomerByCustomerNO(Integer.valueOf(customerNO));
        model.addAttribute("realCustomer", realCustomer);
        return "real-customer-update";
    }

    @PostMapping(value = "/update-real-customer")
    public String updateRealCustomer(@ModelAttribute CustomerDto realCustomer, HttpSession httpSession) {
        try {
            realCustomerService.updateRealCustomer(realCustomer);
            httpSession.setAttribute("updateRealCustomerSuccessMessage",
                    messageSourceComponent.getPersian(
                            "real.customer.successfully.updated", String.valueOf(realCustomer.getCustomerNO())));
            return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/customers";
        } catch (DuplicateNationalCodeException e) {
            httpSession.setAttribute("duplicateNationalCodeException", e.getMessage());
            return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/update-real-customer/" + realCustomer.getCustomerNO();
        }
    }

    @GetMapping(value = "/delete-real-customer/{customerNO}")
    public String deleteRealCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        realCustomerService.deleteRealCustomer(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteRealCustomerSuccessMessage",
                messageSourceComponent.getPersian("real.customer.successfully.deleted", customerNO));
        return "redirect:" + propertyReaderComponent.getProperty("app.domain") + "/customers";
    }
}
