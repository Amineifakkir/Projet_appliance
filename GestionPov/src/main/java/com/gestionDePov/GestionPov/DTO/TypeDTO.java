package com.gestionDePov.GestionPov.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TypeDTO {
    public Long idType;
    public  String Libelle;
}
