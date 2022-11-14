package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.TypeDTO;


import java.util.List;


public interface TypeService {
    TypeDTO save(TypeDTO typeDTO);  //Post
    void delete(Long type);  //Delete

    List<TypeDTO> findAllType(); //Get

    TypeDTO Update(Long type,TypeDTO typeDTO); //Put
}
