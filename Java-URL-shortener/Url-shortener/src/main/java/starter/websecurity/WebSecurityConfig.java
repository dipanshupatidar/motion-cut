package starter.websecurity;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{ 
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	 public void configureGlobalSecurity (AuthenticationManagerBuilder auth) throws Exception 
	{
			
	auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Override
	protected void configure ( HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/account").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
		
		http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
		
	}
	
}