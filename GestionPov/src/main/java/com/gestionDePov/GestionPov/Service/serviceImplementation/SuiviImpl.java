package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.SeancePageDTO;
import com.gestionDePov.GestionPov.DTO.SuiviDTO;
import com.gestionDePov.GestionPov.DTO.SuiviPageDTO;
import com.gestionDePov.GestionPov.Mapping.SuiviMapper;
import com.gestionDePov.GestionPov.Model.Seance;
import com.gestionDePov.GestionPov.Model.Suivi;
import com.gestionDePov.GestionPov.Repository.SuiviRepo;
import com.gestionDePov.GestionPov.Service.SuiviService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class SuiviImpl implements SuiviService {
    @Autowired
    SuiviRepo suiviRepo;
    @Autowired
    SuiviMapper suiviMapper;
    @Override
    public SuiviDTO save(SuiviDTO suivi) {
        return suiviMapper.SuiviToSuiviDTO(suiviRepo.save(suiviMapper.SuiviDTOToSuivi(suivi)));

    }

    @Override
    public void delete(Long suivi) {
        boolean exists =suiviRepo.existsById(suivi);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+ suivi +" does not exists");

        }

        suiviRepo.deleteById(suivi);

    }

    @Override
    public SuiviPageDTO findAll(Pageable pageRequest) {
        Page<Suivi> data =  suiviRepo.findAll(pageRequest);
        SuiviPageDTO suiviPageDto = new  SuiviPageDTO();
        suiviPageDto.setTotalItems(data.getTotalElements());
        suiviPageDto.setPages(suiviMapper.ListEntitySuiviToDtoSuivi(data.getContent()));

        return suiviPageDto;

    }

    @Override
    public List<SuiviDTO> findAll() {
        return suiviMapper.ListEntitySuiviToDtoSuivi(suiviRepo.findAll());
    }

    @Override
    public SuiviDTO Update(Long type, SuiviDTO suiviDTO) {
        boolean exists =suiviRepo.existsById(type);
        if (exists){
            suiviDTO.setIdSuivi(type);
            suiviRepo.save(suiviMapper.SuiviDTOToSuivi(suiviDTO));

        }

        return suiviDTO;
    }

    @Override
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {

    }
}
