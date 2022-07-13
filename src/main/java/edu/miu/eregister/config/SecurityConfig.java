package edu.miu.eregister.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers()
            .frameOptions().sameOrigin()
            .and()
            .authorizeRequests()
            .antMatchers("/resources/static/**", "/css/**", "/images/**", "/js/**", "/eregister/public/**").permitAll()
            .antMatchers("/", "/eregister").permitAll()
            .antMatchers("/eregister/secured/services/admin/**").hasRole("ADMIN")
            .antMatchers("/eregister/secured/services/registrar/**").hasRole("REGISTRAR")
            .antMatchers("/eregister/secured/services/student/**").hasRole("STUDENT")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/eregister/public/login")
            .defaultSuccessUrl("/eregister/public/home")
            .failureUrl("/eregister/public/login?error")
            .permitAll()
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/eregister/public/logout"))
            .logoutUrl("/eregister/public/logout")
            .logoutSuccessUrl("/eregister/public/login?logout")
            .permitAll()
            .and()
            .exceptionHandling();
    }
}
