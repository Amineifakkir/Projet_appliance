package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Model.TypePrestation;

import java.util.List;

public interface TypePrestationService {
    TypePrestation save(TypePrestation typePrestation);

    void delete(Long type);

    List<TypePrestation> findAll();
}
