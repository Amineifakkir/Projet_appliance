package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.Model.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepo extends JpaRepository<Appliance,Long> {
}
