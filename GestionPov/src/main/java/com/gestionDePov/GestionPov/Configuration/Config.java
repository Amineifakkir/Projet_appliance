package com.gestionDePov.GestionPov.Configuration;

import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.RepositoryType;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.MARCH;

@Configuration
public class Config {
    @Bean
    DozerBeanMapper dozerBeanMapper(){
        return new DozerBeanMapper();
    };
   }
