package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;

import com.gestionDePov.GestionPov.DTO.SeancePageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


public interface SeanceService {
    SeanceDTO save(SeanceDTO seance);
    void delete(Long seance);

    SeancePageDTO findAll(Pageable pageRequest);

    SeanceDTO Update(Long idSeance, SeanceDTO typeDTO);
}
