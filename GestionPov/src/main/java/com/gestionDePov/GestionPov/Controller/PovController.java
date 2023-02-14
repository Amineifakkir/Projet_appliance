package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.*;

import com.gestionDePov.GestionPov.Repository.PovRepo;
import com.gestionDePov.GestionPov.Service.ApplianceService;
import com.gestionDePov.GestionPov.Service.ClientService;
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
@RequestMapping("/Pov")
public class PovController {
    @Autowired
    private  PovService pov;

    @Autowired
    private ClientService client;
    @Autowired
    private ApplianceService appliance;
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
    public List<POVDTO> findPOV(){

        return pov.findAll();

    }

    @GetMapping("/FindAppliance")
    public List<ApplianceDTO> findAppliance() {

        return appliance.findAll();

    }

    @GetMapping("/FindClient")
    public List<ClientDTO> registerNewStudents(){

        return client.findAll();

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
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {



        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(povRepo.findAll());



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy","Amine");

        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Jasper/Pov.jrxml"));

        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);


        response.setContentType("application/x-pdf");
        response.setHeader("Content-Disposition", "inline; filename=Pov.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);







    }

}
