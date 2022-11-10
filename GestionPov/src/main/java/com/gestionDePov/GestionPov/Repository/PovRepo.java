package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Model.POV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PovRepo extends JpaRepository<POV,Long> {
}
