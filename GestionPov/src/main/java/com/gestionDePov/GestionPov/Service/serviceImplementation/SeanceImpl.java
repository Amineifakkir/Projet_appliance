package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Mapping.SeanceMapper;
import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Repository.SeanceRepo;
import com.gestionDePov.GestionPov.Service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceImpl implements SeanceService {

    @Autowired
    SeanceRepo seanceRepo;
    @Autowired
    SeanceMapper seanceMapper;

    @Override
    public SeanceDTO save(SeanceDTO seance) {
        return seanceMapper.SeanceToSeanceDTO(seanceRepo.save(seanceMapper.SeanceDtoToSeance(seance)));
    }

    @Override
    public void delete(Long seance) {
        boolean exists =seanceRepo.existsById(seance);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+seance+" does not exists");
        }
        seanceRepo.deleteById(seance);

    }

    @Override
    public List<SeanceDTO> findAll() {
        return seanceMapper.ListSeanceDTOToEntitySeance(seanceRepo.findAll());
    }
}

