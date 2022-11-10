package com.gestionDePov.GestionPov.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class POVDTO {
    public Long idPov;
    public ApplianceDTO idAppliance;
    public ClientDTO idClient;
    public Date Date_Debut;
    public Date Date_Fin;
    public String Description;
    public String CompteManager;
    public String Ingenieur_CyberSecurite;
    public String Analyse_CyberSecurite;
    public String Libelle_Pov;
}
