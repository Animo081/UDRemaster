package com.vector.udremaster.vsya_fignya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;

@Configuration
@CrossOrigin(origins = "http://localhost:4200")
@EnableWebSecurity(debug = true)
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and().formLogin().loginProcessingUrl("/user/login")
                .and().logout().logoutUrl("/user/logout");
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("SELECT login, password, 1 "
                        + "FROM users "
                        + "WHERE login = ?")
                .authoritiesByUsernameQuery("SELECT login, authority "
                        + "FROM authorities "
                        + "WHERE login = ?");
    }
}