package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.DTO.AppliancePageDto;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Repository.ApplianceRepo;
import com.gestionDePov.GestionPov.Service.ApplianceService;

import com.gestionDePov.GestionPov.Service.SuiviService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ApplianceImpl;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/Appliance")
public class ApplianceController {
    @Autowired
    private ApplianceService appliance;
    @Autowired
    private ApplianceRepo applianceRepo;

    @PostMapping("/add") //add
    public ApplianceDTO getAppliances(@RequestBody ApplianceDTO appliances) {
        return appliance.save(appliances);
    }

    @GetMapping("/Find") //Get
    public AppliancePageDto findAppliance(@RequestParam int page, @RequestParam int size) {

        return appliance.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/Findtp")
    public List<ApplianceDTO> registerNewStudents() {

        return appliance.findAll();

    }

    @DeleteMapping("/Delete/{type}") //Delete
    public void deleteType(@PathVariable Long type) {
        appliance.delete(type);
    }


    @PutMapping("/Update/{idApp}") //Update
    public ApplianceDTO updateAppliance(@PathVariable Long idApp, @RequestBody ApplianceDTO applianceDTO) {
        return appliance.Update(idApp, applianceDTO);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(applianceRepo.findAll());

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