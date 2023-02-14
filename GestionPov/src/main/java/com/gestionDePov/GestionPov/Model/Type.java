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

public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idType;


    public  String libelle;


    @OneToMany(mappedBy = "idType" ,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Appliance> appliances;

}
