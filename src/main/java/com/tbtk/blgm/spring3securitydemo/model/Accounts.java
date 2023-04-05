package com.tbtk.blgm.spring3securitydemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Accounts {

	@Column(name = "customer_id")
	private int customerId;

	@Column(name="account_number")
	@Id
	private long accountNumber;

	@Column(name="account_type")
	private String accountType;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "create_dt")
	private String createDt;

}
