package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;
import com.gestionDePov.GestionPov.DTO.ClientDTO;
import com.gestionDePov.GestionPov.DTO.ContactDTO;
import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Service.ContactService;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ContactImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contact")
public class ContactController {
    @Autowired
    private  ContactService contact;


    @PostMapping("/GetContact")
    public ContactDTO getContact(@RequestBody ContactDTO contactDTO) {
        return contact.save(contactDTO);
    }
    @GetMapping("/FindAppliance")
    public List<ContactDTO> findContact() {
        return contact.findAll();
    }
    @DeleteMapping("/DeleteType/{idContact}")
    public void deleteType(@PathVariable("idContact") Long idContact) {
        contact.delete(idContact);
    }


    @PutMapping("/Update/{idContact}")
    public  ContactDTO UpdateType(@PathVariable("idContact") Long idContact, @RequestBody ContactDTO contactDTO){
        return contact.Update(idContact,contactDTO);
    }

}
