package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.Model.Type;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TypeService {
    Type save(Type type);
    void delete(Long type);

    List<Type> findAll();
}
