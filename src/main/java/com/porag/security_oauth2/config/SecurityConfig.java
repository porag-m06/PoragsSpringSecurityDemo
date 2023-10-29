package com.porag.security_oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChainMP(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(requests->{
            requests.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                    .requestMatchers("/notices","/contact").permitAll();
        })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

//________ Permitting all requests ______________________________________
//        httpSecurity.authorizeHttpRequests(authorizeRequests ->{
//            authorizeRequests.anyRequest().permitAll();
//        })
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//        return httpSecurity.build();



// ________ denying all requests ______________________________________
//        httpSecurity.authorizeHttpRequests(requests ->{
//            requests.anyRequest().denyAll();
//        }).formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
    }

}//class
