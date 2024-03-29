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

public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idAppliance;
    public  String Libelle;
    @ManyToOne
    @JoinColumn(name = "idType")
    @Enumerated
    public Type idType; //FK_TYPE


    public String DBID;
    public boolean Disponibilitte;
    public String References;

@OneToMany(mappedBy = "idAppliance" ,cascade = CascadeType.REMOVE, orphanRemoval = true )
    public List<POV> POV; //Fk in table POV




}
