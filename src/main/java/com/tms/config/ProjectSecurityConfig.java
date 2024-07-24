package com.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    

    /*  Approach 1 where we use withDefaultPasswordEncoder()
        method while creating the user details*/
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .authorities("ADMIN")
            .build();
            
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user")
            .authorities("USER")
            .build();
        
        return new InMemoryUserDetailsManager(admin,user);
    }*/
    /*  Approach 2 where we use NoOpPasswordEncoder Bean
        while creating the user details*/
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withUsername("admin")
            .password("admin")
            .authorities("ADMIN")
            .build();
            
        UserDetails user = User.withUsername("user")
            .password("user")
            .authorities("USER")
            .build();
        
        return new InMemoryUserDetailsManager(admin,user);
    }
    //  ++
    // NoOpPasswordEncoder is not recommended for production usage
    //Use only for non-prod
    */
  /*  
    @Bean 
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    // 
    /*@Bean
    public UserDetailsService userDetailsService(DataSource DataSource){
        return new JdbcUserDetailsManager(DataSource);
    }*/

    @Bean
    SecurityFilterChain defauSecurityFilterChain(HttpSecurity http) throws Exception{
        
        // Not all incoming request shoud be authorised
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/myAccounts/**","/myBalance/**","/myLoans/**","/myCards/**").authenticated()
            .requestMatchers("/","/notices","/contact","/register").permitAll();
        http.formLogin();
        http.httpBasic();

        // *** Bydefault *** // All incoming request shoud be authorised
        /*http.authorizeHttpRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();*/

        // All requests are denied.
        /*http.authorizeHttpRequests().anyRequest().denyAll();
        http.formLogin();
        http.httpBasic();*/

        // All requests are allowed.
        /*http.authorizeHttpRequests().anyRequest().permitAll();
        http.formLogin();
        http.httpBasic();*/

        return http.build();
    }
}
