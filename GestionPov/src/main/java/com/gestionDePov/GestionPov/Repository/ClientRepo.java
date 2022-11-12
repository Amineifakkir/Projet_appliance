package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepo extends JpaRepository<Client,Long> {
}
