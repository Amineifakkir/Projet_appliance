package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.POVDTO;

import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface PovService {
    POVDTO save(POVDTO pov);
    void delete(Long Pov);

    List<POVDTO> findAll();

    POVDTO Update(Long idPov, POVDTO povDTO);

}
