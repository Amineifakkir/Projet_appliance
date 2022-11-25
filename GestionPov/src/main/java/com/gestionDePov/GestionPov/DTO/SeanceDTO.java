package com.gestionDePov.GestionPov.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SeanceDTO {
    public Long idSeance;
    public Date DateSceance;
    public String Resumer;
    public String Participant;
    public POVDTO povSeance;

}
