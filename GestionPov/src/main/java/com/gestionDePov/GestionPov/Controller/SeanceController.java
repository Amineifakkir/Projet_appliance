package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.SeanceDTO;

import com.gestionDePov.GestionPov.DTO.SeancePageDTO;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Repository.SeanceRepo;
import com.gestionDePov.GestionPov.Service.SeanceService;

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
@RequestMapping("/Seance")
public class SeanceController {
@Autowired
    private SeanceService seance;

    @Autowired
    private SeanceRepo seanceRepo;
    @PostMapping("/add")
    public SeanceDTO getSeance(@RequestBody SeanceDTO seanceDTO) {
        return seance.save(seanceDTO);
    }
    @GetMapping("/Find")
    public SeancePageDTO findSeance(@RequestParam int page, @RequestParam int size) {
        return seance.findAll(PageRequest.of(page, size));
    }
    @DeleteMapping("/Delete/{idSeance}")
    public void deleteSeance(@PathVariable("idSeance") Long idSeance) {
        seance.delete(idSeance);
    }
    @GetMapping("/Findtp")
    public List<SeanceDTO> registerNewStudents(){

        return seance.findAll();

    }

    @PutMapping("/Update/{idSeance}")
    public  SeanceDTO updateSeance(@PathVariable("idSeance") Long idSeance, @RequestBody SeanceDTO seanceDTO){
        return seance.Update(idSeance,seanceDTO);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(seanceRepo.findAll());

        System.out.println(beanCollectionDataSource);

        Map<String, Object> parameters = new HashMap<>();


        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Jasper/Type.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "Type.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Type.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }
}
