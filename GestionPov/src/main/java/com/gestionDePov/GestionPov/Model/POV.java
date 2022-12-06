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
    public Long idPov;

    //idAPP

    @ManyToOne
    @JoinColumn(name = "idAppliance")
    public Appliance idAppliance;
    //IdClient
    @ManyToOne
    @JoinColumn(name = "idClient")
    public Client idClient;

    public Date Date_Debut;
    public Date Date_Fin;
    public String Description;
    public String CompteManager;
    public String Ingenieur_CyberSecurite;
    public String Analyse_CyberSecurite;
    public String Libelle_Pov;

    @OneToMany(mappedBy = "povSuivi",cascade = CascadeType.REMOVE, orphanRemoval = true )
    public List<Suivi> suivis;

    @OneToMany(mappedBy = "povSeance",cascade = CascadeType.REMOVE, orphanRemoval = true )
    public List<Seance> seances;
}
