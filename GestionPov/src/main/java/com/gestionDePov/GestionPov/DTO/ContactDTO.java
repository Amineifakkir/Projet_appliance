package com.gestionDePov.GestionPov.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContactDTO {
    public int idContact;
    public String Nom;
    public String Prenom;
    public String Telephone;
    public  String Fonction;
    public ClientDTO idClient;
    public  String Email;
}
