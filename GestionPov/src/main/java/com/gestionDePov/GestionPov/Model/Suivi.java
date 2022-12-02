package com.gestionDePov.GestionPov.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class Suivi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idSuivi;
    public boolean OffreCommercial;
    public float   Montant;

    //idTypePres
    @ManyToOne
    @JoinColumn(name = "idTypePrestation")
    public TypePrestation TypePres;


    public String CompteRendu;

    //idPov
    @ManyToOne
    @JoinColumn(name = "idPov")
    public POV povSuivi;

}
