package io.github.sebastiangb1.appfranquicias.service;

import io.github.sebastiangb1.appfranquicias.models.Sucursal;
import io.github.sebastiangb1.appfranquicias.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepo;

    public void saveSucursal(Sucursal sucursal){
        sucursalRepo.save(sucursal);
    }

    public List<Sucursal> findAll(){
        return sucursalRepo.findAll();
    }

    public Sucursal update(Long id, Sucursal sucursal){
        Sucursal sucursalUpdate = sucursalRepo.findById(id).orElseThrow();
        sucursalUpdate.setNombre(sucursal.getNombre());
        return sucursalRepo.save(sucursalUpdate);
    }
}
