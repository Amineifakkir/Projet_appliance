package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


public interface TypeService {
    TypeDTO save(TypeDTO typeDTO);  //Post
    void delete(Long type);  //Delete

    TypePageDTO findAllType(Pageable pageRequest); //Get
    List<TypeDTO> findAll();

    TypeDTO Update(Long type,TypeDTO typeDTO); //Put
}
