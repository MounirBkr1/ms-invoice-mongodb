package com.ensa.msinvoice.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class InMemorySecurityService extends WebSecurityConfigurerAdapter{

    //Basic Auth in postmane

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            BCryptPasswordEncoder bcpe=getBCryptPasswordEncoder();

            auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("123")).roles("ADMIN","USER");

        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {

           //super.configure(http);
            http.csrf().disable();
            http.authorizeRequests().anyRequest().permitAll();        }

        @Bean
        public BCryptPasswordEncoder getBCryptPasswordEncoder(){
           return  new BCryptPasswordEncoder();
        }

}
