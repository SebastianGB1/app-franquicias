package io.github.sebastiangb1.appfranquicias.service;

import io.github.sebastiangb1.appfranquicias.models.Franquicia;
import io.github.sebastiangb1.appfranquicias.repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {
    @Autowired
    private FranquiciaRepository franquiciaRepo;

    public void save(Franquicia franquicia){
        franquiciaRepo.save(franquicia);
    }

    public List<Franquicia> findAll(){
        return franquiciaRepo.findAll();
    }

    public Franquicia update(Long id, Franquicia franquicia){
        Franquicia franquiciaUpdate = franquiciaRepo.findById(id).orElseThrow();
        franquiciaUpdate.setNombre(franquicia.getNombre());
        return franquiciaRepo.save(franquiciaUpdate);
    }
}
