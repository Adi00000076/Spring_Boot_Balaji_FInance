package com.balaji.finance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.balaji.finance.filter.JwtFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Value("${app.cors.allowed-origin}")
	private String allowedOrigins;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
				// REST API → disable CSRF
				.csrf(csrf -> csrf.disable())

				// No session (stateless)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				// Authorization rules
				.authorizeHttpRequests(auth -> auth.requestMatchers("/balaji-finance/auth/**" ,"/balaji-finance/addUser").permitAll() // login, register
						.anyRequest().authenticated() // secure all other APIs
				)

				// Disable form login and default login page
				.formLogin(form -> form.disable()).httpBasic(httpBasic -> httpBasic.disable());

		// Add JWT filter BEFORE UsernamePasswordAuthenticationFilter
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		/*
		 http
	        // Disable CSRF for H2 console
	        .csrf(csrf -> csrf.disable())

	        // Allow H2 console frames
	        .headers(headers -> headers.frameOptions(frame -> frame.disable()))

	        // No sessions → JWT stateless
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

	        // Authorization rules
	        .authorizeHttpRequests(auth -> auth
	                .requestMatchers(
	                        "/auth/**",
	                        "/h2-console/**"
	                        ,"/addUser"
	                ).permitAll()
	                .anyRequest().authenticated()
	        )

	        // Disable form login + basic auth
	        .formLogin(form -> form.disable())
	        .httpBasic(httpBasic -> httpBasic.disable());

	    // Add JWT filter BEFORE UsernamePasswordAuthenticationFilter
	    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
*/

		return http.build();
		
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	        	
	        	 String[] origins = allowedOrigins.split(",");

	        	 
	            registry.addMapping("/**")
	                    .allowedOrigins(origins)
	                    .allowedMethods("GET","POST","PUT","DELETE")
	                    .allowedHeaders("*")
	                    .allowCredentials(true);
	        }
	    };
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
