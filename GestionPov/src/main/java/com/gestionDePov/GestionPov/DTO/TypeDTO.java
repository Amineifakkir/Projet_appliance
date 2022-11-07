package com.gestionDePov.GestionPov.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class TypeDTO {
    public int idType;
    public  String Libelle;
}
