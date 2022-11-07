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
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idAppliance;
    public  String Libelle;
    @ManyToOne
    @JoinColumn(name = "idType")
    public Type idApp;
    public String DBID;
    public String Disponibilitte;
    public String References;






    @OneToMany(mappedBy = "idAppliance" )
    public List<POV> POV;




}
