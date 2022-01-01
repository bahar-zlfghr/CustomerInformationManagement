package com.dotin.service.loantype;

import com.dotin.dto.LoanTypeDto;
import com.dotin.mapper.loantype.LoanTypeMapper;
import com.dotin.model.repository.LoanTypeRepository;
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
public class LoanTypeServiceImpl implements LoanTypeService {
    private final LoanTypeRepository loanTypeRepository;
    private final LoanTypeMapper loanTypeMapper;
    private final Logger logger = Logger.getLogger(LoanTypeServiceImpl.class);

    public LoanTypeServiceImpl(LoanTypeRepository loanTypeRepository, LoanTypeMapper loanTypeMapper) {
        this.loanTypeRepository = loanTypeRepository;
        this.loanTypeMapper = loanTypeMapper;
    }

    @Override
    public LoanTypeDto saveLoanType(LoanTypeDto loanTypeDto) {
        logger.info("Loan type information is being stored...");
        LoanTypeDto savedLoanType = loanTypeMapper.toLoanTypeDto(
                loanTypeRepository.save(loanTypeMapper.toLoanType(loanTypeDto)));
        logger.info("Loan type information with name '" + savedLoanType.getName() + "' was successfully saved.");
        return savedLoanType;
    }

    @Override
    public LoanTypeDto getLoanTypeByID(Integer customerNO) {
        logger.info("Loan type information is being found by ID...");
        LoanTypeDto loanTypeDto = loanTypeMapper.toLoanTypeDto(
                loanTypeRepository.getById(customerNO));
        logger.info("Loan type with ID '" + loanTypeDto.getId() + "' was successfully found.");
        return loanTypeDto;
    }

    @Override
    public List<LoanTypeDto> getAllLoanTypes() {
        logger.info("Loan types information is being fetch...");
        List<LoanTypeDto> loanTypes = loanTypeRepository.findAll()
                .stream()
                .map(loanTypeMapper::toLoanTypeDto)
                .collect(Collectors.toList());
        logger.info("All loan types information was successfully found.");
        return loanTypes;
    }
}
