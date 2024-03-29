package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ClientDTO;

import com.gestionDePov.GestionPov.DTO.ClientPageDto;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ClientService {

    ClientDTO save(ClientDTO client);
    void delete(Long idClt);

    ClientPageDto findAll(Pageable pageRequest);
    List<ClientDTO> findAll();
    ClientDTO Update(Long idClient, ClientDTO clientDTO);

    void getEnRpt(HttpServletResponse response) throws JRException, IOException;

}
