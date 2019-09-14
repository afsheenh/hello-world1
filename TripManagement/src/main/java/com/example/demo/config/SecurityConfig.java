package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("india").password("{noop}india").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		/*
		 * http.authorizeRequests().antMatchers("/tripsdb").authenticated()
		 * .and().antMatcher("/h2") .csrf().disable()
		 * .formLogin().and().logout().logoutUrl("/logout");
		 */
		
		//http.authorizeRequests().antMatchers("/tripsdb").authenticated()
		//.and().antMatcher("/h2")
		//.csrf().disable().httpBasic();
		
		
		//Web version
		/*
		 * http.authorizeRequests().antMatchers("/","/*.html","/h2/**")
		 * .permitAll().antMatchers("/tripsdb").authenticated()
		 * .and().formLogin().and().logout().logoutSuccessUrl("/tripsdb")
		 * .invalidateHttpSession(true).deleteCookies("JSESSIONID")
		 * .and().csrf().disable(); http.headers().frameOptions().sameOrigin();
		 */

		
		//Microservice Version
		
		  http.authorizeRequests().antMatchers("/","/*.html","/h2/**")
		  .permitAll().antMatchers("/tripsdb").authenticated()
		  .and().httpBasic().and().csrf().disable();
		  
		  http.headers().frameOptions().sameOrigin();
		 		 		 
		
	}

}
