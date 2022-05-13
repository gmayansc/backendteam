package edu.uoc.backendteam.paracasa.config;

import edu.uoc.backendteam.paracasa.config.filter.JWTAuthenticationFilter;
import edu.uoc.backendteam.paracasa.config.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.uoc.backendteam.paracasa.service.UserDetailsServiceImpl;

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
    	http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/","/css/*","/js/","/images/*","/register","/register-login","/register-process","/register-success").permitAll()
        .antMatchers(
        		"/authenticate",
                "/swagger-resources/**",
                "/swagger-ui/**",
                "/v3/api-docs",
                "/webjars/**").permitAll()
        //.antMatchers("/admin/**").hasAnyRole("ADMIN")
        //.antMatchers("/user/**").hasAnyRole("USER")
        //.antMatchers("/api/**").hasAnyRole("USER")
        .anyRequest().authenticated()
                /*
                 // agregando el login
                .and().httpBasic()
                .and()
                    .formLogin()
                     .loginPage("/login")
                .defaultSuccessUrl("/user/productos")
                        .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");
                */
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}
