package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.ContactDTO;

import com.gestionDePov.GestionPov.DTO.ContactPageDto;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Repository.ContactRepo;
import com.gestionDePov.GestionPov.Service.ContactService;

import com.gestionDePov.GestionPov.Service.SuiviService;
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
@RequestMapping("/Contact")
public class ContactController {
    @Autowired
    private  ContactService contact;

    @Autowired
    private ContactRepo contactRepo;
    @PostMapping("/add")
    public ContactDTO getContact(@RequestBody ContactDTO contactDTO) {
        return contact.save(contactDTO);
    }
    @GetMapping("/Find")
    public ContactPageDto findContact(@RequestParam int page, @RequestParam int size) {
        return contact.findAll(PageRequest.of(page, size));
    }
    @GetMapping("/Findtp")
    public List<ContactDTO> registerNewStudents(){

        return contact.findAll();

    }
    @DeleteMapping("/Delete/{idContact}")
    public void deleteType(@PathVariable("idContact") Long idContact) {
        contact.delete(idContact);
    }


    @PutMapping("/Update/{idContact}")
    public  ContactDTO UpdateType(@PathVariable Long idContact, @RequestBody ContactDTO contactDTO){
        return contact.Update(idContact,contactDTO);
    }


    @GetMapping("/pdf")
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {



        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(contactRepo.findAll());



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/Contact.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=Contact.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }

}
