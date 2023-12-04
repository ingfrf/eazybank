package com.enmivida.eazybank.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class ProjectSecurityConfig {

    private final DataSource dataSource;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // @Deprecated
        /*return http.authorizeHttpRequests()
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact").permitAll()
                .and().formLogin()
                .and().httpBasic()
                .build()
        ;*/
        return httpSecurity
                .cors().configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    // origen permitido
                    config.setAllowedOrigins(Collections.singletonList("http://192.168.1.111:8060"));
                    // métodos GET POST PUT ...
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    // se dejan pasar todas las cabeceras
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    // esta configuracion sera valida un hora antes de volver a chequearla
                    config.setMaxAge(3600L);
                    return config;
                })
                // concatena diferentes configuraciones
                .and()
                .csrf().disable()
                .authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                                .requestMatchers("/notices", "/contact", "/register").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build()
                ;
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User
                .withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails user = User
                .withUsername("user")
                .password("12345")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
