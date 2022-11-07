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

    public int idType;
    public  String Libelle;


    @OneToMany(mappedBy = "idApp" )
    public List<Appliance> appliances;

}
