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
    public Long idClt;
    public  String Libelle;
    public  String Secteur;
    public String Activite;

    @OneToMany(mappedBy = "idClient" , cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<Contact> Contact;

    @OneToMany(mappedBy = "idClient", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public List<POV> POV;
}
