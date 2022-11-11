package com.gestionDePov.GestionPov.Service.serviceImplementation;

import com.gestionDePov.GestionPov.Model.Type;
import com.gestionDePov.GestionPov.Repository.TypeRepo;
import com.gestionDePov.GestionPov.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImpl implements TypeService {
    @Autowired
    TypeRepo typeRepo;

    @Override
    public Type save(Type type) {
        return typeRepo.save(type);
    }

    @Override
    public void delete(Long idType) {
        boolean exists =typeRepo.existsById(idType);
        if (!exists){
            throw new IllegalStateException(
                    "Type with id "+idType+" does not exists");

        }
        typeRepo.deleteById(idType);

    }
    @Override
    public List<Type> findAll(){
        return typeRepo.findAll();
    }
}
