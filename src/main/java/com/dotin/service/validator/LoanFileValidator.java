package com.dotin.service.validator;

import com.dotin.dto.LoanFileDto;
import com.dotin.exception.LoanFileAmountNotValidException;
import com.dotin.exception.LoanFilePeriodNotValidException;
import com.dotin.model.data.GrantCondition;
import com.dotin.service.component.MessageSourceComponent;
import org.apache.log4j.Logger;
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
        Logger logger = Logger.getLogger(LoanFileValidator.class);
        logger.info("Period of loan file is being validated...");
        if (grantConditions.stream()
                .noneMatch(grantCondition ->
                        period >= grantCondition.getMinPeriod() && period <= grantCondition.getMaxPeriod())) {
            LoanFilePeriodNotValidException loanFilePeriodNotValidException = new LoanFilePeriodNotValidException(
                    messageSourceComponent.getPersian("loan.file.period.not.valid", loanFileDto.getLoanType().getName()));
            logger.error("The period of loan file isn't valid!");
            exceptions.add(loanFilePeriodNotValidException);
        }
        logger.error("The period of loan file is valid");
    }

    static void validateLoanFileAmount(MessageSourceComponent messageSourceComponent, LoanFileDto loanFileDto,
                                       List<GrantCondition> grantConditions, BigDecimal amount,
                                       List<RuntimeException> exceptions) {
        Logger logger = Logger.getLogger(LoanFileValidator.class);
        logger.info("Amount of loan file is being validated...");
        if (grantConditions.stream()
                .noneMatch(grantCondition ->
                        amount.compareTo(grantCondition.getMinAmount()) >= 0 &&
                                amount.compareTo(grantCondition.getMaxAmount()) <= 0)) {
            LoanFileAmountNotValidException loanFileAmountNotValidException = new LoanFileAmountNotValidException(
                    messageSourceComponent.getPersian("loan.file.amount.not.valid", loanFileDto.getLoanType().getName()));
            logger.error("The amount of loan file isn't valid!");
            exceptions.add(loanFileAmountNotValidException);
        }
        logger.error("The amount of loan file is valid.");
    }
}
