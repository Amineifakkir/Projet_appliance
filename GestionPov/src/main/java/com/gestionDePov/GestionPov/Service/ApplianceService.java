package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.DTO.AppliancePageDto;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplianceService {


    ApplianceDTO save(ApplianceDTO appliance);
    void delete(Long appliance);

    AppliancePageDto findAll(Pageable pageRequest);
    List<ApplianceDTO> findAll();
     ApplianceDTO Update(Long type, ApplianceDTO applianceDTO);

}
