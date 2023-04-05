package com.tbtk.blgm.spring3securitydemo.repository;

import com.tbtk.blgm.spring3securitydemo.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
