package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.RepositoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceType {
 private final RepositoryType repositoryType;
@Autowired
    public ServiceType(RepositoryType repositoryTest) {
        this.repositoryType= repositoryTest;
    }

    public List<Type> Type() {
        return  repositoryType.findAll();
    }

}
