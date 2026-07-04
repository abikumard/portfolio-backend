package com.abikumar.portfoliobackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(auth -> auth

						.requestMatchers("/auth/**", "/otp/**", "/resume/download", "/visitor/**", "/hr/save",
								"/project/**","/skill/**","/experience/**")
						.permitAll()

						.requestMatchers("/admin/**")

						.hasRole("ADMIN")

						.anyRequest()

						.authenticated())

				.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}