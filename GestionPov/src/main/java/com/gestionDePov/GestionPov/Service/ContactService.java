package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ContactDTO;

import com.gestionDePov.GestionPov.DTO.ContactPageDto;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public interface ContactService {
    ContactDTO save(ContactDTO contact);
    void delete(Long contact);

    ContactPageDto findAll(Pageable pageRequest);
    List<ContactDTO> findAll();
    ContactDTO Update(Long idContact, ContactDTO contactDTO);

    void getEnRpt(HttpServletResponse response) throws JRException, IOException;

}
