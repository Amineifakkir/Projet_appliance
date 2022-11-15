package com.gestionDePov.GestionPov.Mapping;


import com.gestionDePov.GestionPov.DTO.ContactDTO;
import com.gestionDePov.GestionPov.Model.Contact;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;



public class ContactMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    ClientMapper clientMapper;


    //Entity To Dto
    public ContactDTO ContactToContactDTO(Contact Ct){
        ContactDTO CtDTO = dozerBeanMapper.map(Ct,ContactDTO.class);

        if(Ct.getIdClient() != null){
            Ct.setIdClient(clientMapper.ClientDTOToClient(CtDTO.getIdClient()));
         }
        return CtDTO;
    }
    //       Dto To Entity
    public Contact ContactDTOToContact (ContactDTO contactDTO) {
        Contact Ct = dozerBeanMapper.map(contactDTO, Contact.class);
        if (contactDTO.getIdClient() != null) {
            contactDTO.setIdClient(clientMapper.ClientToClientDTO(Ct.getIdClient()));
        }
        return Ct;

    }
        //
        //List Dto To List Entity
        public List<ContactDTO> ListContactDTOToEntityContact (List < Contact > contacts) {

            List<ContactDTO> LstContactDto = new ArrayList<>();
            contacts.forEach(ContactDTO -> LstContactDto.add(ContactToContactDTO(ContactDTO)));

            return LstContactDto;
        }


//    //List Entity To List DTO
        public List<Contact> ListEntityContactToEntityContact (List < ContactDTO > contactDTOS) {

            List<Contact> LstContact = new ArrayList<>();
            contactDTOS.forEach(Contact -> LstContact.add(ContactDTOToContact(Contact)));
            return LstContact;

        }

}
