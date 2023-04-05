package com.tbtk.blgm.spring3securitydemo.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contact_messages")
@Data
public class Contact {

	@Id
	@Column(name = "contact_id")
	private String contactId;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_email")
	private String contactEmail;
	
	private String subject;

	private String message;

	@Column(name = "create_dt")
	private Date createDt;

}
