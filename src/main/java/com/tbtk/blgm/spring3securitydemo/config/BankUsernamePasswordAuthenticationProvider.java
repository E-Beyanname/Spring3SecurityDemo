package com.tbtk.blgm.spring3securitydemo.config;

import com.tbtk.blgm.spring3securitydemo.model.Authority;
import com.tbtk.blgm.spring3securitydemo.model.Customer;
import com.tbtk.blgm.spring3securitydemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class BankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<Customer> customers = customerRepository.findCustomerByEmail(username);

        if(!customers.isEmpty()){
            if(passwordEncoder.matches(password,customers.get(0).getPassword())){
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username,password,
                        getGrandtedAuthorities(customers.get(0).getAuthorities()));
            }
            else
                throw new BadCredentialsException("Invalid Password");
        }
        else
            throw new BadCredentialsException("No User Registered with this Details");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getGrandtedAuthorities(Set<Authority> authorities){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Authority authority: authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return grantedAuthorities;
    }
}
