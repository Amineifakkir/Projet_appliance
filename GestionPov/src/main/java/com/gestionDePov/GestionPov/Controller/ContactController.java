package com.gestionDePov.GestionPov.Controller;


import com.gestionDePov.GestionPov.DTO.ContactDTO;

import com.gestionDePov.GestionPov.DTO.ContactPageDto;
import com.gestionDePov.GestionPov.Service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Contact")
public class ContactController {
    @Autowired
    private  ContactService contact;


    @PostMapping("/add")
    public ContactDTO getContact(@RequestBody ContactDTO contactDTO) {
        return contact.save(contactDTO);
    }
    @GetMapping("/Find")
    public ContactPageDto findContact(@RequestParam int page, @RequestParam int size) {
        return contact.findAll(PageRequest.of(page, size));
    }
    @DeleteMapping("/Delete/{idContact}")
    public void deleteType(@PathVariable("idContact") Long idContact) {
        contact.delete(idContact);
    }


    @PutMapping("/Update/{idContact}")
    public  ContactDTO UpdateType(@PathVariable Long idContact, @RequestBody ContactDTO contactDTO){
        return contact.Update(idContact,contactDTO);
    }

}
