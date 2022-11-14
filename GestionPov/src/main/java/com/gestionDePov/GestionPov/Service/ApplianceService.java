package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Model.Appliance;

import java.util.List;

public interface ApplianceService {


    ApplianceDTO save(ApplianceDTO appliance);
    void delete(Long appliance);

    List<ApplianceDTO> findAll();

}
