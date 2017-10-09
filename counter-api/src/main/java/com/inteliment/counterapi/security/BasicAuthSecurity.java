package com.inteliment.counterapi.security;
public class BasicAuthSecurity{}
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class BasicAuthSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private BasicAuthEntryPoint basicAuthEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
               // .antMatchers("/css/**", "/free/**").permitAll()
                .antMatchers("/top/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .authenticationEntryPoint(basicAuthEntryPoint)
                .and()
                .csrf().disable();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("vikas").password("patel").roles("ADMIN");
    }
}
*/