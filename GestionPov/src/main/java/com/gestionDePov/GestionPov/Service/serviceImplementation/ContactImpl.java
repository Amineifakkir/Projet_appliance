package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.Client;
import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Repository.ClientRepo;
import com.gestionDePov.GestionPov.Repository.ContactRepo;
import com.gestionDePov.GestionPov.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactImpl implements ContactService {

    @Autowired
    ContactRepo contactRepo;

    public Contact save(Contact contact) {
        return contactRepo.save(contact);
    }
}
