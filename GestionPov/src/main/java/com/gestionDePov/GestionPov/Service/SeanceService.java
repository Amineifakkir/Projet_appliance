package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;

import com.gestionDePov.GestionPov.DTO.SeancePageDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public interface SeanceService {
    SeanceDTO save(SeanceDTO seance);
    void delete(Long seance);

    SeancePageDTO findAll(Pageable pageRequest);

    List<SeanceDTO> findAll();
    SeanceDTO Update(Long idSeance, SeanceDTO typeDTO);

    void getEnRpt(HttpServletResponse response) throws JRException, IOException;
}
