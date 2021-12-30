package com.dotin.service.loanfile;

import com.dotin.dto.LoanFileDto;
import com.dotin.mapper.loanfile.LoanFileMapper;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.data.GrantCondition;
import com.dotin.model.repository.GrantConditionRepository;
import com.dotin.model.repository.LoanFileRepository;
import com.dotin.service.component.MessageSourceComponent;
import com.dotin.service.validator.LoanFileValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
@Transactional
public class LoanFileServiceImpl implements LoanFileService {
    private final LoanFileRepository loanFileRepository;
    private final GrantConditionRepository grantConditionRepository;
    private final LoanFileMapper loanFileMapper;
    private final LoanTypeMapper loanTypeMapper;
    private final MessageSourceComponent messageSourceComponent;
    private final List<RuntimeException> exceptions = new ArrayList<>();

    public LoanFileServiceImpl(LoanFileRepository loanFileRepository,
                               GrantConditionRepository grantConditionRepository,
                               LoanFileMapper loanFileMapper,
                               LoanTypeMapper loanTypeMapper,
                               MessageSourceComponent messageSourceComponent) {
        this.loanFileRepository = loanFileRepository;
        this.grantConditionRepository = grantConditionRepository;
        this.loanFileMapper = loanFileMapper;
        this.loanTypeMapper = loanTypeMapper;
        this.messageSourceComponent = messageSourceComponent;
    }

    @Override
    public void saveLoanFile(LoanFileDto loanFileDto) {
        List<GrantCondition> grantConditions =
                grantConditionRepository.findAllByLoanType(loanTypeMapper.toLoanType(loanFileDto.getLoanType()));
        LoanFileValidator.validateLoanFilePeriod(
                messageSourceComponent, loanFileDto,grantConditions, loanFileDto.getPeriod(), exceptions);
        LoanFileValidator.validateLoanFileAmount(
                messageSourceComponent, loanFileDto, grantConditions, loanFileDto.getAmount(), exceptions);
        if (exceptions.isEmpty()) {
            loanFileRepository.save(loanFileMapper.toLoanFile(loanFileDto));
        }
    }

    @Override
    public List<RuntimeException> getExceptions() {
        return exceptions;
    }
}
