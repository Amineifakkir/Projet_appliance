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
    public  String Libelle;


    @OneToMany(mappedBy = "idType" )
    public List<Appliance> appliances;



}
