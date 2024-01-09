package com.codeup.codeupspringblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/ads/create", "/ads/*/edit", "/posts/create", "/posts/*/edit").authenticated()
                        .requestMatchers("/", "/ads", "/ads/*", "/posts/*", "/posts", "/login").permitAll()
                        .requestMatchers("/js/*", "/css/*", "/img/*").permitAll())
                .formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/posts"))
                .logout(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
