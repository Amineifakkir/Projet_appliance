package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import com.gestionDePov.GestionPov.DTO.TypePrestationDTO;
import com.gestionDePov.GestionPov.Repository.SuiviRepo;
import com.gestionDePov.GestionPov.Service.SuiviService;

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
@RequestMapping("/Suivi")
public class SuiviController {
@Autowired
    private  SuiviService suivi;
    @Autowired
    private TypePrestationService typePrestation;
@Autowired
private SuiviRepo suiviRepo;
    @PostMapping("/add")
    public SuiviDTO getSuivi(@RequestBody SuiviDTO suiviDTO) {
        return suivi.save(suiviDTO);
    }
    @GetMapping("/Find")
    public SuiviPageDTO findSuivi(@RequestParam int page, @RequestParam int size) {
        return suivi.findAll(PageRequest.of(page, size));
    }
    @DeleteMapping("/Delete/{idSuivi}")
    public void deleteSuivi(@PathVariable("idSuivi") Long idSuivi) {
        suivi.delete(idSuivi
        );
    }

    @GetMapping("/Findtp")
    public List<SuiviDTO> registerNewStudents(){

        return suivi.findAll();

    }


    @PutMapping("/Update/{idSuivi}")
    public SuiviDTO updateSuivi(@PathVariable("idSuivi") Long idSuivi, @RequestBody SuiviDTO suiviDTO){
        return suivi.Update(idSuivi,suiviDTO);
    }

    @GetMapping("/Findtype")
    public List<TypePrestationDTO> findTypePrestation(){

        return typePrestation.findAll();

    }

    @GetMapping("/pdf")
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {



        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(suiviRepo.findAll());



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/Suivi.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=Suivi.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }



}
