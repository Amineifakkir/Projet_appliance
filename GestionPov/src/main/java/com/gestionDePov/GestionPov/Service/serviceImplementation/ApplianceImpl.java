package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.DTO.AppliancePageDto;
import com.gestionDePov.GestionPov.Mapping.ApplianceMapper;
import com.gestionDePov.GestionPov.Model.Appliance;
import com.gestionDePov.GestionPov.Repository.ApplianceRepo;
import com.gestionDePov.GestionPov.Service.ApplianceService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ApplianceImpl implements ApplianceService {

    @Autowired
    ApplianceRepo applianceRepo;
    @Autowired
    ApplianceMapper applianceMapper;
    @Override
    public ApplianceDTO save(ApplianceDTO appliance) {

        return applianceMapper.ApplianceToApplianceDTO(
                applianceRepo.save(
                        applianceMapper.ApplianceDTOToAppliance(appliance)
                )
        );
    }

    @Override
    public void delete(Long idAppliance) {
        boolean exists =applianceRepo.existsById(idAppliance);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+idAppliance+" does not exists");
        }
        applianceRepo.deleteById(idAppliance);

    }

    @Override
    public AppliancePageDto findAll(Pageable pageRequest) {
        Page<Appliance> data = applianceRepo.findAll(pageRequest);
        AppliancePageDto appliancePageDto = new AppliancePageDto();
        appliancePageDto.setTotalItems(data.getTotalElements());
        appliancePageDto.setPages(applianceMapper.ListEntityApplianceToDtoAppliance(data.getContent()));

        return appliancePageDto;
    }

    @Override
    public List<ApplianceDTO> findAll() {
        return applianceMapper.ListEntityApplianceToDtoAppliance(applianceRepo.findAll());
    }

    @Override
    public ApplianceDTO Update(Long type, ApplianceDTO applianceDTO) {
        boolean exists =applianceRepo.existsById(type);
        if (exists){
            applianceDTO.setIdAppliance(type);
            applianceRepo.save(applianceMapper.ApplianceDTOToAppliance(applianceDTO));

        }

        return applianceDTO;


    }

    @Override
    public void getEnRpt(HttpServletResponse response) throws JRException, IOException {

    }
}

