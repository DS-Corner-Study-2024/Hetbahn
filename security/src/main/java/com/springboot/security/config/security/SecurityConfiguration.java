package com.springboot.security.config.security;

import com.springboot.security.config.security.CustomAccessDeniedHandler.CustomAccessDeniedHandler;
import jakarta.websocket.OnError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfiguration {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfiguration(final JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable()

                .csrf().disable()

                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequest()
                .andMatchers("/sign-api/sign-in", "/sign-api/sign-up",
                        "/sign-api/exception").permitAll()
                .andMatchers(HttpMethod.GET, "/product/**").permitAll()

                .andMatcher("**exception*").permitAll()

                .anyRequest().hasRole("ADMIN")

                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())

                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().andMatchers("/2/api-docs", "/swagger-resources/**",
                "/swagger-ui.html", "webjars/**", "/swagger/**", "/sign-api/exception");
    }
}