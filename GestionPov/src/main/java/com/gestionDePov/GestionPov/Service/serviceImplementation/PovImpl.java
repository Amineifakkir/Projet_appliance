package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.ContactPageDto;
import com.gestionDePov.GestionPov.DTO.POVDTO;
import com.gestionDePov.GestionPov.DTO.PovPageDto;
import com.gestionDePov.GestionPov.DTO.SeanceDTO;
import com.gestionDePov.GestionPov.Mapping.PovMapper;

import com.gestionDePov.GestionPov.Model.Contact;
import com.gestionDePov.GestionPov.Model.POV;
import com.gestionDePov.GestionPov.Repository.PovRepo;
import com.gestionDePov.GestionPov.Service.PovService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public PovPageDto findAll(Pageable pageRequest) {
        Page<POV> data = povRepo.findAll(pageRequest);
        PovPageDto povPageDto = new PovPageDto();
        povPageDto.setTotalItems(data.getTotalElements());
        povPageDto.setPages(povMapper.ListPovToPovDto(data.getContent()));

        return povPageDto;
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

    @Override
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {

    }


}


