package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.DTO.SuiviDTO;
import com.gestionDePov.GestionPov.Model.Seance;

import java.util.List;

public interface SeanceService {
    SeanceDTO save(SeanceDTO seance);
    void delete(Long seance);

    List<SeanceDTO> findAll();
}
