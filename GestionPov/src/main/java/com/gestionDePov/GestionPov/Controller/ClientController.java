package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.AppliancePageDto;
import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.DTO.ClientPageDto;
import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Repository.ClientRepo;
import com.gestionDePov.GestionPov.Service.ClientService;

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
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientService client;
    @Autowired
    private ClientRepo clientRepo;

    @PostMapping("/add")
    public ClientDTO getClient(@RequestBody ClientDTO clientDTO) {
        return client.save(clientDTO);
    }
    @GetMapping("/Find")
    public ClientPageDto findClient(@RequestParam int page, @RequestParam int size) {
        return client.findAll(PageRequest.of(page, size));
    }
    @GetMapping("/Findtp")
    public List<ClientDTO> registerNewStudents(){

        return client.findAll();

    }
    @DeleteMapping("/Delete/{idClt}")
    public void deleteClient(@PathVariable("idClt") Long idClt) {
        client.delete(idClt);
    }


    @PutMapping("/Update/{idClient}")
    public  ClientDTO updateClient(@PathVariable("idClient") Long idClient, @RequestBody ClientDTO clientDTO){
        return client.Update(idClient,clientDTO);
    }

    @GetMapping("/pdf")
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {



        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(clientRepo.findAll());



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/Client.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=Client.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }

}
