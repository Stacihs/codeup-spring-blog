package com.codeup.codeupspringblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/ads/create", "/ads/*/edit", "/posts/create", "/posts/*/edit").authenticated()
                .requestMatchers("/", "/ads", "/ads/*", "/posts/", "/posts").permitAll()
                .requestMatchers("/js/*", "/css/*", "/img/*").permitAll())
            .formLogin(withDefaults());
        return http.build();
    }
}
