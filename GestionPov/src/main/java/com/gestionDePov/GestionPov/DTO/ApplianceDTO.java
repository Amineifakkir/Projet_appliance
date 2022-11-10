package com.gestionDePov.GestionPov.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data


public class ApplianceDTO {

    public Long idAppliance;
    public  String Libelle;
    public TypeDTO idTypeDTO; //FK_TYPE
    public String DBID;
    public String Disponibilitte;
    public String References;











}
