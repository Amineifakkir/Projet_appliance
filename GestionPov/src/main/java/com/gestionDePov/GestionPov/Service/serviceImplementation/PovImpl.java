package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.Mapping.PovMapper;

import com.gestionDePov.GestionPov.Repository.PovRepo;
import com.gestionDePov.GestionPov.Service.PovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PovImpl implements PovService {
    @Autowired
    PovRepo povRepo;
@Autowired
PovMapper povMapper;

    @Override
    public POVDTO save(POVDTO pov) {

        return povMapper.PovToPovDTO( povRepo.save(povMapper.PovDtoToPov(pov)));

    }

    @Override
    public void delete(Long Pov) {
        boolean exists =povRepo.existsById(Pov);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+Pov+" does not exists");
        }
        povRepo.deleteById(Pov);

    }

    @Override
    public List<POVDTO> findAll() {
        return povMapper.ListPovToPovDto(povRepo.findAll());
    }

    @Override
    public POVDTO Update(Long idPov, POVDTO povDTO) {
        boolean exists =povRepo.existsById(idPov);
        if (exists){
            povDTO.setIdPov(idPov);
            povRepo.save(povMapper.PovDtoToPov(povDTO));

        }

        return povDTO;
    }

}


