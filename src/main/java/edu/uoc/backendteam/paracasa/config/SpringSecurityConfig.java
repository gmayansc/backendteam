package edu.uoc.backendteam.paracasa.config;

import edu.uoc.backendteam.paracasa.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // para crear user / roles
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws  Exception{

        builder.userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(passwordEncoder);



    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/register","/register-login","/register-process","/register-success").permitAll()
                .antMatchers("/nuevo/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/create/**").hasAnyRole("ADMIN")
                .antMatchers("/edit/**").hasAnyRole("ADMIN")
                .antMatchers("/delete/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                // agregando el login
                .and()
                    .formLogin()
                     .loginPage("/login")
                .defaultSuccessUrl("/productos")
                        .permitAll()
                .and()
                .logout().permitAll();



    }
}
