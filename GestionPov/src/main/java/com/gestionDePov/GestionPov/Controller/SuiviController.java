package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.SuiviDTO;

import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import com.gestionDePov.GestionPov.Repository.SuiviRepo;
import com.gestionDePov.GestionPov.Service.SuiviService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(suiviRepo.findAll());

        System.out.println(beanCollectionDataSource);

        Map<String, Object> parameters = new HashMap<>();


        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Jasper/Suivi.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "Suivi.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Suivi.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

}
