package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.POV;

import java.util.List;

public interface PovService {
    POVDTO save(POVDTO pov);
    void delete(Long Pov);

    List<POVDTO> findAll();

}
