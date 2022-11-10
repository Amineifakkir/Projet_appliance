package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
