package com.gestionDePov.GestionPov.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClientDTO {

    public Long idClt;
    public  String Libelle;
    public  String Secteur;
    public String Activite;

}
