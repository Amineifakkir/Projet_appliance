package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.PovPageDto;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.DTO.SeancePageDTO;
import com.gestionDePov.GestionPov.Mapping.SeanceMapper;
import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Repository.SeanceRepo;
import com.gestionDePov.GestionPov.Service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public SeancePageDTO findAll(Pageable pageRequest){
        Page<Seance> data = seanceRepo.findAll(pageRequest);
        SeancePageDTO seancePageDto = new SeancePageDTO();
        seancePageDto.setTotalItems(data.getTotalElements());
        seancePageDto.setPages(seanceMapper.ListSeanceDTOToEntitySeance(data.getContent()));

        return seancePageDto;
    }

    @Override
    public List<SeanceDTO> findAll() {
        return seanceMapper.ListSeanceDTOToEntitySeance(seanceRepo.findAll());
    }

    @Override
    public SeanceDTO Update(Long idSeance, SeanceDTO seanceDTO) {
        boolean exists =seanceRepo.existsById(idSeance);
        if (exists){
            seanceDTO.setIdSeance(idSeance);
             seanceRepo.save(seanceMapper.SeanceDtoToSeance(seanceDTO));

        }

        return seanceDTO;
    }
}

