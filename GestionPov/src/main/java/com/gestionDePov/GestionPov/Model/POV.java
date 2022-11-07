package com.gestionDePov.GestionPov.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class POV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPov;

    //idAPP
    @ManyToOne
    @JoinColumn(name = "idAppliance")
    public Type idAppliance;
    //IdClient
    @ManyToOne
    @JoinColumn(name = "idClient")
    public Type idClient;

    public Date Date_Debut;
    public Date Date_Fin;
    public String Description;
    public String CompteManager;
    public String Ingenieur_CyberSecurite;
    public String Analyse_CyberSecurite;
    public String Libelle_Pov;

    @OneToMany(mappedBy = "pov" )
    public List<Suivi> suivis;

    @OneToMany(mappedBy = "pov" )
    public List<Seance> seances;
}
