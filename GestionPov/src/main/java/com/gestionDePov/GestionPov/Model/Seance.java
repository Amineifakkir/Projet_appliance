package com.gestionDePov.GestionPov.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idSeance;
    public Date DateSceance;
    public String Resumer;
    public String Participant;

    //id_Pov
    @ManyToOne
    @JoinColumn(name = "idPov")
    public POV pov;
}
