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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idContact;
    public String Nom;
    public String Prenom;
    public String Telephone;
    public  String Fonction;

    @ManyToOne
    @JoinColumn(name = "idClient")
    public Client idClient;

    public  String Email;
    
}
