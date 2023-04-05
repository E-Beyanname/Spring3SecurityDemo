package com.tbtk.blgm.spring3securitydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "pwd")
    private String password;

    @Column(name = "mobile_number")
    private String mobile;

    @Column(name = "role")
    private String role;

    @Column(name = "create_dt")
    private String createDt;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Authority> authorities;

    /*@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Accounts> accounts;*/


}
