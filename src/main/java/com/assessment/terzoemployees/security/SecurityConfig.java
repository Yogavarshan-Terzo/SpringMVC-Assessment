package com.assessment.terzoemployees.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests((authorize)->authorize
                .requestMatchers("/login","/register","/css/**","/js/**","/employees","/employees/new").permitAll()
                .requestMatchers("/path").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        http.formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/employees")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error=true")
                .permitAll()
        ).logout(
                logout->logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
        );

        return http.build();
    }
}