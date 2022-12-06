package com.gestionDePov.GestionPov.Configuration;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@ConditionalOnProperty(name = "keycloak.enabled", havingValue = "true", matchIfMissing = true)
public class KeycloakSpringSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(keycloakAuthenticationProvider());

    }
@Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        http.authorizeRequests().antMatchers("/Type/**").hasAuthority("Admin");
    http.authorizeRequests().antMatchers("/Appliance/**").hasAuthority("Admin");
    http.authorizeRequests().antMatchers("/Client/**").hasAuthority("Admin");
    http.authorizeRequests().antMatchers("/Contact/**").hasAuthority("Admin");
    http.authorizeRequests().antMatchers("/TypePrestation/**").hasAuthority("Admin");
    http.authorizeRequests().antMatchers("/Pov/**").hasAuthority("Manager");
    http.authorizeRequests().antMatchers("/Suivi/**").hasAuthority("Manager");
    http.authorizeRequests().antMatchers("/Seance/**").hasAuthority("Manager");
    http.csrf().disable().authorizeRequests()
            .anyRequest()
            .authenticated();


}
}

