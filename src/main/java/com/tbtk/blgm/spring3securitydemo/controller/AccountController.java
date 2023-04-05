package com.tbtk.blgm.spring3securitydemo.controller;

import com.tbtk.blgm.spring3securitydemo.model.Accounts;
import com.tbtk.blgm.spring3securitydemo.model.Customer;
import com.tbtk.blgm.spring3securitydemo.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getId());
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
}
