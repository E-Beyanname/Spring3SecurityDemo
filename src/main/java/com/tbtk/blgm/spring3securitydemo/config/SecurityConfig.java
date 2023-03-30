package com.tbtk.blgm.spring3securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/myAccount","/myBalance","/myLoans","/myCards")
                .authenticated().requestMatchers("/notices","/contact","/register").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return (SecurityFilterChain)http.build();
    }

    /* JDBC User Auth
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    /*

    In memory User Details Manager

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("123456").authorities("admin").build();
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("123456").authorities("read").build();
        return new InMemoryUserDetailsManager(admin,user);

    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
  */



}
