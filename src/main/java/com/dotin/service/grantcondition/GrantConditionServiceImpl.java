package com.dotin.service.grantcondition;

import com.dotin.model.data.GrantCondition;
import com.dotin.model.data.LoanType;
import com.dotin.model.repository.GrantConditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
public class GrantConditionServiceImpl implements GrantConditionService {
    private final GrantConditionRepository grantConditionRepository;

    public GrantConditionServiceImpl(GrantConditionRepository grantConditionRepository) {
        this.grantConditionRepository = grantConditionRepository;
    }

    @Override
    public void saveAllGrantConditions(List<GrantCondition> grantConditions) {
        grantConditionRepository.saveAll(grantConditions);
    }

    @Override
    public List<GrantCondition> findAllGrantConditionsByLoanType(LoanType loanType) {
        return null;
    }
}
