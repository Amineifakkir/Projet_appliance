package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.POVDTO;

import com.gestionDePov.GestionPov.DTO.PovPageDto;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Repository.PovRepo;
import com.gestionDePov.GestionPov.Service.PovService;

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
@RequestMapping("/Pov")
public class PovController {
    @Autowired
    private  PovService pov;
    @Autowired
    private PovRepo povRepo;

    @PostMapping("/add")
    public POVDTO getPOV(@RequestBody POVDTO povdto) {
        return pov.save(povdto);
    }
    @GetMapping("/Find")
    public PovPageDto findPOV(@RequestParam int page, @RequestParam int size) {
        return pov.findAll(PageRequest.of(page, size));
    }
    @GetMapping("/Findtp")
    public List<POVDTO> registerNewStudents(){

        return pov.findAll();

    }
    @DeleteMapping("/Delete/{idPov}")
    public void deletePov(@PathVariable("idPov") Long idPov) {
        pov.delete(idPov);
    }


    @PutMapping("/Update/{idPov}")
    public  POVDTO UpdatePovdto(@PathVariable Long idPv, @RequestBody POVDTO povdto){
        return pov.Update(idPv,povdto);
    }


    @GetMapping("/pdf")
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(povRepo.findAll());

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
