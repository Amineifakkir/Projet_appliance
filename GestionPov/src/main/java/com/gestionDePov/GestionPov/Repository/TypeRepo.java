package com.gestionDePov.GestionPov.Repository;

import com.gestionDePov.GestionPov.DTO.TypeDTO;
import com.gestionDePov.GestionPov.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type,Long> {

}
