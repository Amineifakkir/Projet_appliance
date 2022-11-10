package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepo extends JpaRepository<Seance,Long> {
}
