package com.dotin.model.repository;

import com.dotin.model.data.LoanFile;
import com.dotin.model.data.RealCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Repository
public interface LoanFileRepository extends JpaRepository<LoanFile, Integer> {

    List<LoanFile> findAllByRealCustomer(RealCustomer realCustomer);
}
