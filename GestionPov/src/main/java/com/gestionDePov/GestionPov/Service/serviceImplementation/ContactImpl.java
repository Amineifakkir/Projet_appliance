package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.ContactDTO;
import com.gestionDePov.GestionPov.Mapping.ContactMapper;
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
    @Autowired
    ContactMapper contactMapper;

    public ContactDTO save(ContactDTO contact) {
        return contactMapper.ContactToContactDTO(contactRepo.save(contactMapper.ContactDTOToContact(contact)));
    }

    @Override
    public void delete(Long contact) {
        boolean exists =contactRepo.existsById(contact);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+contact+" does not exists");
        }
        contactRepo.deleteById(contact);

    }
    }



