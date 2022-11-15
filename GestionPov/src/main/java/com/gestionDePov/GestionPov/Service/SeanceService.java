package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;

import org.springframework.stereotype.Service;


import java.util.List;


public interface SeanceService {
    SeanceDTO save(SeanceDTO seance);
    void delete(Long seance);

    List<SeanceDTO> findAll();

    SeanceDTO Update(Long idSeance, SeanceDTO typeDTO);
}
