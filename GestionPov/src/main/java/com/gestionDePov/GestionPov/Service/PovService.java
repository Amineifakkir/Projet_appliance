package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.POVDTO;

import com.gestionDePov.GestionPov.DTO.PovPageDto;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface PovService {
    POVDTO save(POVDTO pov);
    void delete(Long Pov);

    PovPageDto findAll(Pageable pageRequest);
    List<POVDTO> findAll();
    POVDTO Update(Long idPov, POVDTO povDTO);

    void getEnRpt(HttpServletResponse response) throws JRException, IOException;

}
