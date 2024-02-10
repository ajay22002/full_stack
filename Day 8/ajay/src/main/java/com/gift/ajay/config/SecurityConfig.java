package com.gift.ajay.config;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import com.eventmanagement.event.utils.MyConstant;
import com.gift.ajay.Utils.myconstant;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationConfig jwtAuthenticationconfig;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                    .cors(cors->cors.configurationSource(configurationSource()))
                    .authorizeHttpRequests(authorise->authorise
                    .requestMatchers(myconstant.AUTH+"/**","/swagger-ui/**",
                    "swagger-ui.html/",
                    "/v3/api-docs/**")
                    .permitAll().anyRequest().authenticated())
                    .sessionManagement(session->session.sessionCreationPolicy(STATELESS))
                    .authenticationProvider(authenticationProvider).addFilterBefore(jwtAuthenticationconfig, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();//cors ref forgery
    }
    public CorsConfigurationSource configurationSource(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(myconstant.ORGINS);
        corsConfiguration.setAllowedHeaders(myconstant.HEADERS);
        corsConfiguration.setAllowedMethods(myconstant.METHODS);
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);//to accept any link that is followed by 4000
        return source;
    }
}