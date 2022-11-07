package com.gestionDePov.GestionPov.Configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    DozerBeanMapper dozerBeanMapper(){
        return new DozerBeanMapper();
    };
}
