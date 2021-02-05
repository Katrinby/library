package com.company.libraryFinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("etxetdtr");
        http
                .authorizeRequests()
                .antMatchers( "/genre/{genreId}","/book/search","/author/search",
                        "/storage","/userCabinet","/adminCabinet","/book",
                        "/author","/genre", "/searchResults", "/registration", "/main").permitAll()
                //.antMatchers("/main").authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/loginUser").permitAll()
                .defaultSuccessUrl("/main")
                .usernameParameter("username")
                .and()
                .csrf().disable()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.role_id from usr u inner join usr_role ur on u.id = ur.usr_id where u.username=?");
    }
}
