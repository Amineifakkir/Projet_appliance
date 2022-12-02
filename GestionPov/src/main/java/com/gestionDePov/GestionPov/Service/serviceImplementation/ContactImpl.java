package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.ClientPageDto;
import com.gestionDePov.GestionPov.DTO.ContactDTO;
import com.gestionDePov.GestionPov.DTO.ContactPageDto;
import com.gestionDePov.GestionPov.Mapping.ContactMapper;

import com.gestionDePov.GestionPov.Model.Client;
import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Repository.ContactRepo;
import com.gestionDePov.GestionPov.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ContactImpl implements ContactService {

    @Autowired
    ContactRepo contactRepo;
    @Autowired
    ContactMapper contactMapper;
@Override
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


    @Override
    public ContactPageDto findAll(Pageable pageRequest){

        Page<Contact> data = contactRepo.findAll(pageRequest);
        ContactPageDto contactPageDto = new ContactPageDto();
        contactPageDto.setTotalItems(data.getTotalElements());
        contactPageDto.setPages(contactMapper.ListContactDTOToEntityContact(data.getContent()));

        return contactPageDto;
    }

    @Override
    public List<ContactDTO> findAll() {
        return contactMapper.ListContactDTOToEntityContact(contactRepo.findAll());
    }

    @Override
    public ContactDTO Update(Long idContact, ContactDTO contactDTO) {
        boolean exists =contactRepo.existsById(idContact);
        if (exists){
            contactDTO.setIdContact(idContact);
            contactRepo.save(contactMapper.ContactDTOToContact(contactDTO));

        }

        return contactDTO;
    }
}



