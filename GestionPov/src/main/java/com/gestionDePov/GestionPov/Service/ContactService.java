package com.gestionDePov.GestionPov.Service;

import com.gestionDePov.GestionPov.DTO.ContactDTO;
import com.gestionDePov.GestionPov.Model.Contact;

public interface ContactService {
    ContactDTO save(ContactDTO contact);
    void delete(Long contact);


}
