package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;


import java.util.List;

public interface PovService {
    POVDTO save(POVDTO pov);
    void delete(Long Pov);

    List<POVDTO> findAll();

    POVDTO Update(Long idPov, POVDTO povDTO);

}
