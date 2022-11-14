package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.TypeDTO;


import java.util.List;


public interface TypeService {
    TypeDTO save(TypeDTO typeDTO);
    void delete(Long type);

    List<TypeDTO> findAllType();

    TypeDTO Update(Long type,TypeDTO typeDTO);
}
