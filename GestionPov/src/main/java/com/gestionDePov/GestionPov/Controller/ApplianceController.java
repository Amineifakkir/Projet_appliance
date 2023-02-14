package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.DTO.AppliancePageDto;

import com.gestionDePov.GestionPov.Repository.ApplianceRepo;
import com.gestionDePov.GestionPov.Service.ApplianceService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.OutputStream;
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
    public List<ApplianceDTO> findAppliances() {

        return appliance.findAll();

    }

    @DeleteMapping("/Delete/{idAppliance}") //Delete
    public void deleteType(@PathVariable("idAppliance") Long idAppliance) {
        appliance.delete(idAppliance);
    }


    @PutMapping("/Update/{idApp}") //Update
    public ApplianceDTO updateAppliance(@PathVariable Long idApp, @RequestBody ApplianceDTO applianceDTO) {
        return appliance.Update(idApp, applianceDTO);
    }


    @GetMapping("/pdf")
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException{

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(appliance.findAll());





        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/Appliance.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=Appliance.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }


}