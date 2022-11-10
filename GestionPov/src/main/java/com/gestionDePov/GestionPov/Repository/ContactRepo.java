package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Long> {
}
