package com.tbtk.blgm.spring3securitydemo.repository;

import java.util.List;

import com.tbtk.blgm.spring3securitydemo.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
