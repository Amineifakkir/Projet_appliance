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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public ResponseEntity<byte[]> downloadInvoice() throws JRException, FileNotFoundException {


        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(typeRepo.findAll());

        System.out.println(beanCollectionDataSource);

        Map<String, Object> parameters = new HashMap<>();


        JasperReport compileReport = JasperCompileManager
                .compileReport(new FileInputStream("src/main/resources/Jasper/TypePrestation.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "TypePrestation.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

        System.err.println(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=TypePrestation.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

}
