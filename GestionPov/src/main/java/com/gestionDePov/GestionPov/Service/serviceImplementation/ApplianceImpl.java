package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.DTO.ApplianceDTO;

import com.gestionDePov.GestionPov.DTO.AppliancePageDto;
import com.gestionDePov.GestionPov.Mapping.ApplianceMapper;
import com.gestionDePov.GestionPov.Model.Appliance;
import com.gestionDePov.GestionPov.Repository.ApplianceRepo;
import com.gestionDePov.GestionPov.Service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void delete(Long appliance) {
        boolean exists =applianceRepo.existsById(appliance);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+appliance+" does not exists");
        }
        applianceRepo.deleteById(appliance);

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
    public ApplianceDTO Update(Long type, ApplianceDTO applianceDTO) {
        boolean exists =applianceRepo.existsById(type);
        if (exists){
            applianceDTO.setIdAppliance(type);
            applianceRepo.save(applianceMapper.ApplianceDTOToAppliance(applianceDTO));

        }

        return applianceDTO;


    }
}

