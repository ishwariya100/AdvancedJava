package com.example.LearnBasicAuth.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.LearnBasicAuth.service.UserEntityUserDetailsService;

@Configuration
public class ConfigSecurity {
	
	//Authentication
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserEntityUserDetailsService();
	}
	
	@SuppressWarnings({ "removal", "deprecation" })
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		/*
		return http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/rest/user/register").permitAll()
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/rest/user/api/*")
				.authenticated().and()
				.requestMatchers("/rest/user/api/getByAdmin").hasAuthority("ROLE_ADMIN")
				.and()
				//.formLogin()
				.httpBasic()
				.and()
				.build();
		*/
		
		return http.csrf().disable() // Disable CSRF protection (may be necessary for APIs)
	            .authorizeRequests()
	            .requestMatchers("/rest/user/register").permitAll() // Allow unauthenticated access to registration
	            //.requestMatchers("/rest/user/api/*").authenticated() // Require authentication for API endpoints
	            .requestMatchers("/api/getByAdmin").hasAuthority("ROLE_ADMIN") // Only allow users with ROLE_ADMIN
	            .requestMatchers("/api/getByUser").hasAuthority("ROLE_USER")
	            .anyRequest().authenticated() // Ens	a56																						ure that other requests require authentication
	            .and()
	            .httpBasic() // Enable HTTP Basic Authentication
	            .and()
	            // Optional: You can enable form login if you need a traditional login page
	            //.formLogin()
	            .build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
