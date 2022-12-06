package com.gestionDePov.GestionPov.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class TypePrestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long idTypePres;
    public  String Libelle;


    @OneToMany(mappedBy = "TypePres" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Suivi> suivis;


}
