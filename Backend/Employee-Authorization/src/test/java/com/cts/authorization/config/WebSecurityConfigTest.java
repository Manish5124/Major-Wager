package com.cts.authorization.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@ContextConfiguration(classes = {WebSecurityConfig.class, AuthenticationManagerBuilder.class,
        AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebSecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @MockBean
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @MockBean
    private UserDetailsService userDetailsService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    /**
     * Method under test: {@link WebSecurityConfig#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.HttpSecurity.csrf()" because "httpSecurity" is null
        //       at com.cts.authorization.config.WebSecurityConfig.configure(WebSecurityConfig.java:62)
        //   See https://diff.blue/R013 to resolve this issue.

        webSecurityConfig.configure((HttpSecurity) null);
    }

    /**
     * Method under test: {@link WebSecurityConfig#passwordEncoder()}
     */
    @Test
    void testPasswordEncoder() {
        assertTrue(webSecurityConfig.passwordEncoder() instanceof NoOpPasswordEncoder);
    }

    /**
     * Method under test: {@link WebSecurityConfig#authenticationManagerBean()}
     */
    @Test
    void testAuthenticationManagerBean() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        webSecurityConfig.authenticationManagerBean();
    }
}

