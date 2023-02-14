package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePageDTO;
import com.gestionDePov.GestionPov.Mapping.TypeMapper;
import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.core.io.Resource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class TypeImpl implements TypeService {
    @Autowired
    TypeRepo typeRepo;
@Autowired
    TypeMapper typeMapper;
//adding another line int DataBase

    private final Path root = Paths.get("uploads");
    @Override
    public TypeDTO save(TypeDTO typedto) {
       return typeMapper.TypeToTypeDTO(
               typeRepo.save(
                       typeMapper.TypeDTOToType(typedto)
               )
       );

    }
//Deleting an existing Line In the database
    @Override
    public void delete(Long idType) {
        boolean exists =typeRepo.existsById(idType);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+ idType +" does not exists");

        }

        typeRepo.deleteById(idType);

    }

    @Override
    public TypePageDTO findAllType(Pageable pageRequest){

        Page<Type> data =  typeRepo.findAll(pageRequest);
        TypePageDTO typePageDto = new  TypePageDTO();
        typePageDto.setTotalItems(data.getTotalElements());
        typePageDto.setPages(typeMapper.ListEntityTypeToListType(data.getContent()));

        return typePageDto;

    }

    @Override
    public List<TypeDTO> findAll() {
        return typeMapper.ListEntityTypeToListType(typeRepo.findAll());
    }

    @Override
    public TypeDTO Update(Long type,TypeDTO typeDTO) {
        boolean exists =typeRepo.existsById(type);
        if (exists){
            typeDTO.setIdType(type);
            typeRepo.save(typeMapper.TypeDTOToType(typeDTO));

        }

   return typeDTO;
    }

    @Override
//    public String exportPdf(String reportFormat) throws FileNotFoundException, JRException {
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException{



        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(typeRepo.findAll());



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/Type.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=Type.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }



    }


