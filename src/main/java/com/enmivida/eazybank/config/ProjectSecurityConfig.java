package com.enmivida.eazybank.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
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
        CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        // por defecto la clase se inicia con este nombre sin necesidad de setearlo
        // pero se setea manualmente para que sea mas legible
        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");

        return httpSecurity
 /*
                // dejamos que el framework autogestione el JSESSIONID
                // si el valor fuese a true (que es el por defecto)
                // habría que guardar las credenciales y gestionarlas en el SecurityContext
                .securityContext(sc -> sc.requireExplicitSave(false))
                // ya no es necesaria la página de login por defecto
                // se va a generar un JSESSIONID cada vez se cree una sesion (login)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
*/
                .cors(cors -> cors.configurationSource(request -> {
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
                }))
/*
                .csrf(csrf -> {
                    csrf
                            .csrfTokenRequestHandler(requestAttributeHandler)
                            // no se aplica el csrf (notices no esta porque es un GET y no modifica datos)
                            .ignoringRequestMatchers("/contact", "/register")
                            // This configuration will set a XSRF-TOKEN cookie to the front end.
                            // Because we set the HTTP-only flag to false, the front end will be able to retrieve this cookie using JavaScript.
                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    ;
                })
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
*/
                .csrf(csrf -> csrf.disable())
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
