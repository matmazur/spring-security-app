package com.matmazur.springsecurityboot.configuration;

import com.matmazur.springsecurityboot.security.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@SpringBootConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "/register").permitAll()
                .antMatchers("/admin-page").hasAuthority("ROLE_ADMIN").anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .formLogin();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder = auth.jdbcAuthentication().dataSource(dataSource);
//        JdbcUserDetailsManager userDetailsManager = builder.getUserDetailsService();
//        userDetailsManager.setUsersByUsernameQuery("select username,password,enabled from accounts where username = ?");
//        userDetailsManager.setAuthoritiesByUsernameQuery("select username,authority from roles where username = ?");
//        userDetailsManager.setCreateUserSql("insert into accounts(username,password,enabled) values(?,?,?)");
//        userDetailsManager.setCreateAuthoritySql("insert into roles(username,authority) values(?,?)");
//
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .withUser("mike").password("{bcrypt}ekim").roles("USER")
//                .and()
//                .withUser("admin").password("{bcrypt}pass").roles("ADMIN", "USER");
//    }