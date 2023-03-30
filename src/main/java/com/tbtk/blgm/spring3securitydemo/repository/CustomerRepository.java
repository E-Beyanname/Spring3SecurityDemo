package com.tbtk.blgm.spring3securitydemo.repository;

import com.tbtk.blgm.spring3securitydemo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findCustomerByEmail(String email);
}
