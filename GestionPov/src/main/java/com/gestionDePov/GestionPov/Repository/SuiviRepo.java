package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Model.Suivi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuiviRepo extends JpaRepository<Suivi,Long> {
}
