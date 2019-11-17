package com.github.modullo11.stes.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .ignoringAntMatchers("/introspect");

        http.authorizeRequests()
                .antMatchers("/introspect").permitAll()
                .antMatchers("/token").authenticated()
                .antMatchers("/debug/**").permitAll()
                .anyRequest().authenticated();

        http.oauth2ResourceServer()
                .jwt();
    }

}
