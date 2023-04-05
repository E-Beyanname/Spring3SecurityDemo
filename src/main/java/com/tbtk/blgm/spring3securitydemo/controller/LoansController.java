package com.tbtk.blgm.spring3securitydemo.controller;

import com.tbtk.blgm.spring3securitydemo.model.Customer;
import com.tbtk.blgm.spring3securitydemo.model.Loans;
import com.tbtk.blgm.spring3securitydemo.repository.LoanRepository;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @PostMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestBody Customer customer) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

}
