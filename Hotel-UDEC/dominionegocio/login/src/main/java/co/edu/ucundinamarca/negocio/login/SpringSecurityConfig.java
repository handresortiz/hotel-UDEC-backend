package co.edu.ucundinamarca.negocio.login;

import co.edu.ucundinamarca.negocio.login.auth.filter.JWTAuthenticationFilter;
import co.edu.ucundinamarca.negocio.login.auth.filter.JWTAuthorizationFilter;
import co.edu.ucundinamarca.negocio.login.auth.handler.LoginSuccessHandler;
import co.edu.ucundinamarca.negocio.login.model.service.JpaUserDetailsService;
import co.edu.ucundinamarca.negocio.login.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler successHandler;

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private JWTService jwtService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter( new JWTAuthenticationFilter( authenticationManager(), jwtService ))
                .addFilter( new JWTAuthorizationFilter( authenticationManager(), jwtService) )
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
    {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
