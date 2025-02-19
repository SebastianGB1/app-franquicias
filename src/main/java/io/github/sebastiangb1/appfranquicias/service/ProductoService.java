package io.github.sebastiangb1.appfranquicias.service;

import io.github.sebastiangb1.appfranquicias.exception.RecursoNoEncontradoException;
import io.github.sebastiangb1.appfranquicias.models.Producto;
import io.github.sebastiangb1.appfranquicias.models.Sucursal;
import io.github.sebastiangb1.appfranquicias.repository.ProductoRepository;
import io.github.sebastiangb1.appfranquicias.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private SucursalRepository sucursalRepo;

    public void save(Producto producto){
        productoRepo.save(producto);
    }
    public List<Producto> findBySucursal(Long sucursal_id){
        Sucursal sucursal = sucursalRepo.findById(sucursal_id).orElseThrow(()->new RecursoNoEncontradoException("Sucursal no encontrada"));
        return productoRepo.findBySucursal(sucursal);
    }
}
