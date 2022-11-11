package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Model.Type;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TypeService {
    TypeDTO save(TypeDTO typeDTO);
    void delete(Long type);

//    List<TypeDTO> findAll(List<Type> types);
}
