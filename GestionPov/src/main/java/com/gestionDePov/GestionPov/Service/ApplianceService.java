package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.DTO.TypeDTO;

import java.util.List;

public interface ApplianceService {


    ApplianceDTO save(ApplianceDTO appliance);
    void delete(Long appliance);

    List<ApplianceDTO> findAll();

     ApplianceDTO Update(Long type, ApplianceDTO applianceDTO);

}
