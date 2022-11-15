package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplianceService {


    ApplianceDTO save(ApplianceDTO appliance);
    void delete(Long appliance);

    List<ApplianceDTO> findAll();

     ApplianceDTO Update(Long type, ApplianceDTO applianceDTO);

}
