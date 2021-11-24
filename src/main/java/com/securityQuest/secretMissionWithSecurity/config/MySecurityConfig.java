package com.securityQuest.secretMissionWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/avengers/assemble").hasRole("HEROES")
                .antMatchers("/secret-bases").hasRole("DIRECTOR").anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("Steve Guy")
                    .password(encoder.encode("password"))
                    .roles("USER")
                .and()
                .withUser("Tony Stark")
                    .password(encoder.encode("12345678"))
                    .roles("HEROES")
                .and()
                .withUser("Nick Fury")
                    .roles("DIRECTOR")
                    .password(encoder.encode("Start123"));
    }
}
