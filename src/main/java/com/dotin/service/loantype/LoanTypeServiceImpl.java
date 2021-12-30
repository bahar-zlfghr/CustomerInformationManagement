package com.dotin.service.loantype;

import com.dotin.dto.LoanTypeDto;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.repository.LoanTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public LoanTypeDto getLoanTypeByID(Integer customerNO) {
        return loanTypeMapper.toLoanTypeDto(
                loanTypeRepository.getById(customerNO));
    }

    @Override
    public List<LoanTypeDto> getAllLoanTypes() {
        return loanTypeRepository.findAll()
                .stream()
                .map(loanTypeMapper::toLoanTypeDto)
                .collect(Collectors.toList());
    }
}
