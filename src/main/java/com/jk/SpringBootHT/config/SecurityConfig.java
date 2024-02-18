package com.jk.SpringBootHT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    // Määritellään filtteri, mille kaikille endointeille sallitaan rekisteröimättömien käyttäjien pääsy,
    // Tässä tapauksessa pääsy sallittu kaikkii. Suodatusta tapahtuu thymeleaf template:ssa jossa sivun
    // sisältö määräytyy sen mukaan onko käyttäjä kirjautunut vai ei.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().permitAll()
                )
                .formLogin(withDefaults());
        return http.build();
    }

    // Määritellään AuthenticationManager, jotta on vastuussa authentikoinnista läpi koko sovelluksen.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
