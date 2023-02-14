package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePageDTO;

import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.*;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.HashMap;
import java.util.Map;




import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Type")
public class TypeController { 
@Autowired
    private TypeService typeService;

@Autowired
private TypeRepo typeRepo;

@Autowired
private KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping("/Find")
    public TypePageDTO registerNewStudent(@RequestParam int page, @RequestParam int size){

        return typeService.findAllType(PageRequest.of(page, size));

    }
@GetMapping("/Findtp")
public List<TypeDTO> registerNewStudents(){

    return typeService.findAll();

}
    @PostMapping("/add")
    public TypeDTO getType(@RequestBody TypeDTO type) {
        return typeService.save(type);
    }
    @DeleteMapping("/Delete/{type}")
    public void deleteType(@PathVariable Long type) {
        typeService.delete(type);
    }


    @PutMapping("/Update/{type}")
    public TypeDTO UpdateType(@PathVariable Long type, @RequestBody TypeDTO typeDTO){
        return typeService.Update(type,typeDTO);
    }

    @GetMapping("/pdf")
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
