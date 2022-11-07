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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idType;
    public  String Libelle;
    public  String Secteur;
    public String Activite;

    @OneToMany(mappedBy = "idClient" )
    public List<Contact> idClient;

    @OneToMany(mappedBy = "idClient" )
    public List<POV> POV;
}
