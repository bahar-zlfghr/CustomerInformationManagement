package com.dotin.service.grantcondition;

import com.dotin.dto.GrantConditionDto;
import com.dotin.dto.LoanTypeDto;
import com.dotin.mapper.grantcondition.GrantConditionMapper;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.repository.GrantConditionRepository;
import org.apache.log4j.Logger;
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
    private final Logger logger = Logger.getLogger(GrantConditionServiceImpl.class);

    public GrantConditionServiceImpl(GrantConditionRepository grantConditionRepository, GrantConditionMapper grantConditionMapper, LoanTypeMapper loanTypeMapper) {
        this.grantConditionRepository = grantConditionRepository;
        this.grantConditionMapper = grantConditionMapper;
        this.loanTypeMapper = loanTypeMapper;
    }

    @Override
    public void saveAllGrantConditions(List<GrantConditionDto> grantConditions) {
        logger.info("Grant conditions information is being stored...");
        grantConditionRepository.saveAll(grantConditions
                .stream()
                .map(grantConditionMapper::toGrantCondition)
                .collect(Collectors.toList())
        );
        logger.info("Grant conditions information of loan type with name '" +
                grantConditions.get(0).getLoanTypeDto().getName() + "' were successfully saved.");
    }

    @Override
    public List<GrantConditionDto> findAllGrantConditionsByLoanType(LoanTypeDto loanTypeDto) {
        logger.info("Grand conditions information is being fetched...");
        List<GrantConditionDto> grantConditions = grantConditionRepository
                .findAllByLoanType(loanTypeMapper.toLoanType(loanTypeDto))
                .stream()
                .map(grantConditionMapper::toGrantConditionDto)
                .collect(Collectors.toList());
        logger.info("All grant conditions information of loan type with name '" + loanTypeDto.getName() + "' was successfully found.");
        return grantConditions;
    }
}
