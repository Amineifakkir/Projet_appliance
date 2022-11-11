package com.gestionDePov.GestionPov.Controller;

import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Service.serviceImplementation.ContactImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Contact")
public class ContactController {
    private final ContactImpl contact;

@Autowired
    public ContactController(ContactImpl contact) {
        this.contact = contact;
    }
    @GetMapping("/GetContact")
    public Contact GetConatct(Contact contacts){
    return contact.save(contacts);

    }
}
