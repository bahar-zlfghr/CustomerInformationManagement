package com.dotin.controller;

import com.dotin.dto.CustomerDto;
import com.dotin.dto.LoanFileDto;
import com.dotin.exception.LoanFileAmountNotValidException;
import com.dotin.exception.LoanFilePeriodNotValidException;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.loanfile.LoanFileService;
import com.dotin.service.loantype.LoanTypeService;
import com.dotin.service.realcustomer.RealCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class LoanFileController {
    private final LoanTypeService loanTypeService;
    private final RealCustomerService realCustomerService;
    private final LoanFileService loanFileService;
    private final MessageSourceComponent messageSourceComponent;

    public LoanFileController(LoanTypeService loanTypeService, RealCustomerService realCustomerService,
                              LoanFileService loanFileService, MessageSourceComponent messageSourceComponent) {
        this.loanTypeService = loanTypeService;
        this.realCustomerService = realCustomerService;
        this.loanFileService = loanFileService;
        this.messageSourceComponent = messageSourceComponent;
    }

    @GetMapping(value = "/save-loan-file")
    public ModelAndView getLoanFileCreationForm() {
        ModelAndView modelAndView = new ModelAndView("loan-file-creation");
        modelAndView.addObject("loanFile", new LoanFileDto());
        modelAndView.addObject("loanTypes", loanTypeService.getAllLoanTypes());
        return modelAndView;
    }

    @PostMapping(value = "/save-loan-file")
    public ModelAndView saveLoanFile(@ModelAttribute LoanFileDto loanFile,
                               HttpSession httpSession,
                               BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loanFile", loanFile);
        CustomerDto realCustomer = realCustomerService.findRealCustomerByCustomerNO(loanFile.getRealCustomerNO());
        modelAndView.addObject("realCustomer", realCustomer);
        modelAndView.addObject("realCustomerLoanFiles", loanFileService.findLoanFilesByRealCustomer(realCustomer));
        loanFile.setRealCustomer(realCustomer);
        loanFile.setLoanType(
                loanTypeService.getLoanTypeByID(loanFile.getLoanTypeID()));
        loanFileService.saveLoanFile(loanFile);
        List<RuntimeException> exceptions = loanFileService.getExceptions();
        if (exceptions.size() > 0) {
            modelAndView.setViewName("loan-file-creation");
            setErrorInSession(exceptions, httpSession);
            exceptions.clear();
        }
        else {
            modelAndView.setViewName("index");
            httpSession.setAttribute("saveLoanFileSuccessfullyMessage",
                    messageSourceComponent.getPersian("loan.file.successfully.saved",
                            loanFile.getLoanType().getName(), loanFile.getRealCustomer().getName(), loanFile.getRealCustomer().getLastName()));
        }
        return modelAndView;
    }

    private void setErrorInSession(List<RuntimeException> exceptions, HttpSession httpSession) {
        exceptions.forEach(e -> {
            if (e instanceof LoanFilePeriodNotValidException) {
                httpSession.setAttribute("loanFilePeriodNotValidException", e.getMessage());
            } else if (e instanceof LoanFileAmountNotValidException) {
                httpSession.setAttribute("loanFileAmountNotValidException", e.getMessage());
            }
        });
    }
}
