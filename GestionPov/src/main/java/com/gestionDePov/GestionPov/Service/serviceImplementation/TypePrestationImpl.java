package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.TypePrestation;
import com.gestionDePov.GestionPov.Repository.TypePrestationRepo;
import com.gestionDePov.GestionPov.Service.TypePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePrestationImpl implements TypePrestationService {
    @Autowired
    TypePrestationRepo typePrestationRepo;
    @Override
    public TypePrestation save(TypePrestation typePrestation) {
        return typePrestationRepo.save(typePrestation);
    }
}
