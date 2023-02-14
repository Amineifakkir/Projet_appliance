package com.gestionDePov.GestionPov.Service;


import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationPageDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public interface TypePrestationService {
    TypePrestationDTO save(TypePrestationDTO typePrestation);

    void delete(Long type);

   TypePrestationPageDTO findAlltype(Pageable pageRequest);
    List<TypePrestationDTO> findAll();
    TypePrestationDTO Update(Long type, TypePrestationDTO typeDTO);

    void getEnRpt(HttpServletResponse response) throws JRException, IOException;


}
