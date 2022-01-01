package com.dotin.controller;

import com.dotin.dto.CustomerDto;
import com.dotin.dto.LoanFileDto;
import com.dotin.exception.DuplicateNationalCodeException;
import com.dotin.exception.RealCustomerNotFoundException;
import com.dotin.service.component.PropertyReaderComponent;
import com.dotin.service.loanfile.LoanFileService;
import com.dotin.service.loantype.LoanTypeService;
import com.dotin.service.realcustomer.RealCustomerService;
import com.dotin.service.component.MessageSourceComponent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class RealCustomerController {
    private final RealCustomerService realCustomerService;
    private final MessageSourceComponent messageSourceComponent;
    private final LoanTypeService loanTypeService;
    private final LoanFileService loanFileService;

    public RealCustomerController(RealCustomerService realCustomerService, MessageSourceComponent messageSourceComponent,
                                  LoanTypeService loanTypeService, LoanFileService loanFileService) {
        this.realCustomerService = realCustomerService;
        this.messageSourceComponent = messageSourceComponent;
        this.loanTypeService = loanTypeService;
        this.loanFileService = loanFileService;
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
        return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/";
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
            return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/customers";
        } catch (DuplicateNationalCodeException e) {
            httpSession.setAttribute("duplicateNationalCodeException", e.getMessage());
            return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/update-real-customer/" + realCustomer.getCustomerNO();
        }
    }

    @GetMapping(value = "/delete-real-customer/{customerNO}")
    public String deleteRealCustomer(@PathVariable String customerNO, HttpSession httpSession) {
        realCustomerService.deleteRealCustomer(Integer.valueOf(customerNO));
        httpSession.setAttribute("deleteRealCustomerSuccessMessage",
                messageSourceComponent.getPersian("real.customer.successfully.deleted", customerNO));
        return "redirect:" + PropertyReaderComponent.getProperty("app.domain") + "/customers";
    }

    @GetMapping(value = "/real-customers")
    public ModelAndView getRealCustomerByCustomerNO(@RequestParam(required = false, name = "customerNO") String customerNO,
                                                    @ModelAttribute LoanFileDto loanFileDto,
                                                    HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("loan-file-creation");
        modelAndView.addObject("loanTypes", loanTypeService.getAllLoanTypes());
        modelAndView.addObject("loanFile", new LoanFileDto());
        try {
            CustomerDto realCustomer = realCustomerService.findRealCustomerByCustomerNO(Integer.valueOf(customerNO));
            modelAndView.addObject("realCustomerLoanFiles",
                    loanFileService.findLoanFilesByRealCustomer(realCustomer));
            modelAndView.addObject("realCustomer", realCustomer);
        } catch (RealCustomerNotFoundException e) {
            httpSession.setAttribute("realCustomerNotFoundException",
                    messageSourceComponent.getPersian("real.customer.not.found", customerNO));
        }
        return modelAndView;
    }
}
