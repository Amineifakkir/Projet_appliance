package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.Seance;

public interface SeanceService {
    SeanceDTO save(SeanceDTO seance);
    void delete(Long seance);
}
