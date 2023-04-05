package com.tbtk.blgm.spring3securitydemo.repository;

import com.tbtk.blgm.spring3securitydemo.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
