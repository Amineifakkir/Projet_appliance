package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.DTO.TypePageDTO;
import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;
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

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
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
    public void deleteType(@PathVariable("type") Long type) {
        typeService.delete(type);
    }


    @PutMapping("/Update/{type}")
    public TypeDTO UpdateType(@PathVariable Long type, @RequestBody TypeDTO typeDTO){
        return typeService.Update(type,typeDTO);
    }
    @GetMapping("/pdf")
    public ResponseEntity<byte[]>  downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(typeRepo.findAll());

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
