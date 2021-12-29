package com.dotin.controller;

import com.dotin.dto.GrantConditionDto;
import com.dotin.dto.LoanTypeDto;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.grantcondition.GrantConditionService;
import com.dotin.service.loantype.LoanTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author : Bahar Zolfaghari
 **/
@Controller
public class LoanTypeController {
    private final LoanTypeService loanTypeService;
    private final GrantConditionService grantConditionService;
    private final MessageSourceComponent messageSourceComponent;

    public LoanTypeController(LoanTypeService loanTypeService, GrantConditionService grantConditionService,
                              MessageSourceComponent messageSourceComponent) {
        this.loanTypeService = loanTypeService;
        this.grantConditionService = grantConditionService;
        this.messageSourceComponent = messageSourceComponent;
    }

    @GetMapping(value = "/save-loan-type")
    public String getLoanTypeCreationForm(Model model) {
        model.addAttribute("loanType", new LoanTypeDto());
        return "loan-type-creation";
    }

    @PostMapping(value = "/save-loan-type")
    public ModelAndView saveLoanTypeCreationForm(@RequestBody List<GrantConditionDto> grantConditions,
                                                 HttpSession httpSession) {
        LoanTypeDto loanType = loanTypeService.saveLoanType((LoanTypeDto) httpSession.getAttribute("loanType"));
        grantConditions.forEach(grantCondition -> grantCondition.setLoanTypeDto(loanType));
        grantConditionService.saveAllGrantConditions(grantConditions);
        httpSession.removeAttribute("loanType");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("saveLoanTypeSuccessMessage",
                messageSourceComponent.getPersian(
                        "loan.type.successfully.saved", loanType.getName()));
        return modelAndView;
    }

    @GetMapping(value = "/save-grant-condition")
    public String getGrantConditionCreationForm(@ModelAttribute LoanTypeDto loanType,
                                                HttpSession httpSession) {
        httpSession.setAttribute("loanType", loanType);
        return "grant-condition-creation";
    }
}
