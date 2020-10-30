package com.saidproject.saidproject.config;

import com.saidproject.saidproject.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    /**
     * This method is run everytime our application obtains a request
     * and checks the request against filters
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .httpBasic().and()
//                .authorizeRequests()
//                .antMatchers("/swagger*/**", "/v2/api-docs", "/webjars/**", "/configuration/**").permitAll() //swagger
//                .antMatchers(HttpMethod.GET, "/users/").permitAll()
//                .antMatchers(HttpMethod.POST, "/users/").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/users/").hasRole("ADMIN")
//                .and()
//                .authorizeRequests().antMatchers("/console/**").permitAll()
//                .anyRequest().hasRole("USER,ADMIN");

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//    }
}
