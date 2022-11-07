package com.gestionDePov.GestionPov.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class ApplianceDTO {

    public int idAppliance;
    public  String Libelle;
    public TypeDTO idApp;
    public String DBID;
    public String Disponibilitte;
    public String References;











}
