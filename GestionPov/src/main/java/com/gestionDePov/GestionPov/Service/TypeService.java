package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePageDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;


public interface TypeService {
    TypeDTO save(TypeDTO typeDTO);  //Post
    void delete(Long type);  //Delete

    TypePageDTO findAllType(Pageable pageRequest); //Get
    List<TypeDTO> findAll();

    TypeDTO Update(Long type,TypeDTO typeDTO); //Put\



    void getEnRpt(HttpServletResponse response) throws JRException, IOException;



}
