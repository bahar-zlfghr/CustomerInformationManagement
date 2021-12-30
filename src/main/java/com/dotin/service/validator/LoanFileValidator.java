package com.dotin.service.validator;

import com.dotin.dto.LoanFileDto;
import com.dotin.exception.LoanFileAmountNotValidException;
import com.dotin.exception.LoanFilePeriodNotValidException;
import com.dotin.model.data.GrantCondition;
import com.dotin.service.component.MessageSourceComponent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public interface LoanFileValidator {

    static void validateLoanFilePeriod(MessageSourceComponent messageSourceComponent, LoanFileDto loanFileDto,
                                       List<GrantCondition> grantConditions, Integer period,
                                       List<RuntimeException> exceptions) {
        if (grantConditions.stream()
                .noneMatch(grantCondition ->
                        period >= grantCondition.getMinPeriod() && period <= grantCondition.getMaxPeriod())) {
           exceptions.add(new LoanFilePeriodNotValidException(
                    messageSourceComponent.getPersian("loan.file.period.not.valid", loanFileDto.getLoanType().getName())));
        }
    }

    static void validateLoanFileAmount(MessageSourceComponent messageSourceComponent, LoanFileDto loanFileDto,
                                       List<GrantCondition> grantConditions, BigDecimal amount,
                                       List<RuntimeException> exceptions) {
        if (grantConditions.stream()
                .noneMatch(grantCondition ->
                        amount.compareTo(grantCondition.getMinAmount()) >= 0 &&
                                amount.compareTo(grantCondition.getMaxAmount()) <= 0)) {
            exceptions.add(new LoanFileAmountNotValidException(
                    messageSourceComponent.getPersian("loan.file.amount.not.valid", loanFileDto.getLoanType().getName())));
        }
    }
}
