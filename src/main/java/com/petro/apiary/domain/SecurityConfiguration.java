package com.petro.apiary.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                    .password(passwordEncoder().encode("admin"))
                    .roles("ADMIN").authorities("ACCESS_TEST_ADMIN", "ACCESS_TEST_DIRECTOR", "ACCESS_TEST_WORKER")
                .and()
                .withUser("misha")
                    .password(passwordEncoder().encode("misha"))
                    .roles("DIRECTOR").authorities("ACCESS_TEST_DIRECTOR", "ACCESS_TEST_WORKER")
                .and()
                .withUser("user")
                    .password(passwordEncoder().encode("user"))
                    .roles("WORKER").authorities("ACCESS_TEST_WORKER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .anyRequest().authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/api/rest/test/admin/**").hasAuthority("ACCESS_TEST_ADMIN")     //.hasRole("ADMIN")
                .antMatchers("/api/rest/test/director/**").hasAuthority("ACCESS_TEST_DIRECTOR")      //.hasRole("DIRECTOR")
                .antMatchers("/api/rest/test/worker/**").hasAuthority("ACCESS_TEST_WORKER")        //.hasRole("WORKER")
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
