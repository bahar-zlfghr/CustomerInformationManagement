package com.dotin.service.grantcondition;

import com.dotin.dto.GrantConditionDto;
import com.dotin.dto.LoanTypeDto;
import com.dotin.mapper.grantcondition.GrantConditionMapper;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.repository.GrantConditionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
@Transactional
public class GrantConditionServiceImpl implements GrantConditionService {
    private final GrantConditionRepository grantConditionRepository;
    private final GrantConditionMapper grantConditionMapper;
    private final LoanTypeMapper loanTypeMapper;

    public GrantConditionServiceImpl(GrantConditionRepository grantConditionRepository, GrantConditionMapper grantConditionMapper, LoanTypeMapper loanTypeMapper) {
        this.grantConditionRepository = grantConditionRepository;
        this.grantConditionMapper = grantConditionMapper;
        this.loanTypeMapper = loanTypeMapper;
    }

    @Override
    public void saveAllGrantConditions(List<GrantConditionDto> grantConditions) {
        grantConditionRepository.saveAll(grantConditions
                .stream()
                .map(grantConditionMapper::toGrantCondition)
                .collect(Collectors.toList())
        );
    }

    @Override
    public List<GrantConditionDto> findAllGrantConditionsByLoanType(LoanTypeDto loanTypeDto) {
        return grantConditionRepository
                .findAllByLoanType(loanTypeMapper.toLoanType(loanTypeDto))
                .stream()
                .map(grantConditionMapper::toGrantConditionDto)
                .collect(Collectors.toList());
    }
}
