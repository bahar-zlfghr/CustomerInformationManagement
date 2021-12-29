package com.dotin.service.loantype;

import com.dotin.dto.LoanTypeDto;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.repository.LoanTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Bahar Zolfaghari
 **/
@Service
@Transactional
public class LoanTypeServiceImpl implements LoanTypeService {
    private final LoanTypeRepository loanTypeRepository;
    private final LoanTypeMapper loanTypeMapper;

    public LoanTypeServiceImpl(LoanTypeRepository loanTypeRepository, LoanTypeMapper loanTypeMapper) {
        this.loanTypeRepository = loanTypeRepository;
        this.loanTypeMapper = loanTypeMapper;
    }

    @Override
    public LoanTypeDto saveLoanType(LoanTypeDto loanTypeDto) {
        return loanTypeMapper.toLoanTypeDto(
                loanTypeRepository.save(loanTypeMapper.toLoanType(loanTypeDto)));
    }
}
