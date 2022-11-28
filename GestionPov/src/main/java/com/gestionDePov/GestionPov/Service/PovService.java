package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.POVDTO;

import com.gestionDePov.GestionPov.DTO.PovPageDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

public interface PovService {
    POVDTO save(POVDTO pov);
    void delete(Long Pov);

    PovPageDto findAll(Pageable pageRequest);

    POVDTO Update(Long idPov, POVDTO povDTO);

}
