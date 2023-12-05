package com.example.actuatordemo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
public class ActuatorSecurityConfig {

    /*
     * This spring security configuration does the following
     * 
     * 1. Restrict access to the Shutdown endpoint to the ACTUATOR_ADMIN role.
     * 2. Allow access to all other actuator endpoints.
     * 3. Allow access to static resources.
     * 4. Allow access to the home page (/).
     * 5. All other requests need to be authenticated.
     * 5. Enable http basic authentication to make the configuration complete.
     * You are free to use any other form of authentication.
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(EndpointRequest.toAnyEndpoint());
        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.csrf().disable();
        return http.build();
    }
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // http.csrf().disable();
    // }
}
