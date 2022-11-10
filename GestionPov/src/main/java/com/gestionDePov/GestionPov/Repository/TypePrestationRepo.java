package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Model.TypePrestation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePrestationRepo extends JpaRepository<TypePrestation,Long> {
}
