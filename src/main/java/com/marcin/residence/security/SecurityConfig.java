package com.marcin.residence.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Provides the Spring Web Security features for logging to the application.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .anyRequest().authenticated()
	            .antMatchers("/config/**").hasRole("ADMIN")
	            .antMatchers("/").hasRole("EMPLOYEE")
	        .and()
	            .formLogin()
	            .loginPage("/showLoginPage")
	            .loginProcessingUrl("/authenticateTheUser")
	            .permitAll()
	        .and()
	            .logout().permitAll()
	        .and()
	            .exceptionHandling()
	            .accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/resources/css/**");
	}
}