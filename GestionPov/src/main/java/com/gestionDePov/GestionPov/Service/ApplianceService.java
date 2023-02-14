package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.DTO.AppliancePageDto;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ApplianceService {


    ApplianceDTO save(ApplianceDTO appliance);
    void delete(Long idAppliance);

    AppliancePageDto findAll(Pageable pageRequest);
    List<ApplianceDTO> findAll();
     ApplianceDTO Update(Long type, ApplianceDTO applianceDTO);

    void getEnRpt(HttpServletResponse response) throws JRException, IOException;
}
