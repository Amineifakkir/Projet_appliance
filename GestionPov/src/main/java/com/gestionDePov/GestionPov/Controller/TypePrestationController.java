package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;

import com.gestionDePov.GestionPov.DTO.TypePrestationPageDTO;
import com.gestionDePov.GestionPov.Repository.TypePrestationRepo;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypePrestationService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/TypePrestation")
public class TypePrestationController {
@Autowired
    private TypePrestationService typePrestation;

    @Autowired
    private TypePrestationRepo typeRepo;
    @GetMapping("/Find")
    public TypePrestationPageDTO registerNewStudent(@RequestParam int page, @RequestParam int size){

        return typePrestation.findAlltype(PageRequest.of(page, size));

    }
    @PostMapping("/add")
    public TypePrestationDTO getType(@RequestBody TypePrestationDTO type) {
        return typePrestation.save(type);
    }
    @GetMapping("/Findtp")
    public List<TypePrestationDTO> registerNewStudents(){

        return typePrestation.findAll();

    }
    @DeleteMapping("/Delete/{idTypePres}")
    public void deleteType(@PathVariable("idTypePres") Long idTypePres) {
        typePrestation.delete(idTypePres);
    }

    @PutMapping("/Update/{type}")
    public TypePrestationDTO UpdateType(@PathVariable("type") Long type,@RequestBody TypePrestationDTO typePrestationDTO){
    return typePrestation.Update(type,typePrestationDTO);
    }
    @GetMapping("/pdf")
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {



        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(typeRepo.findAll());



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/TypePrestation.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=TypePrestation.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }


}
