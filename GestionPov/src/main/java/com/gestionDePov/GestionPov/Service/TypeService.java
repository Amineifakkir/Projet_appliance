package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.Model.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    Type save(Type type);
}
