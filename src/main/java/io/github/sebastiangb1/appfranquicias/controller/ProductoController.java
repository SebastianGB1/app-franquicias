package io.github.sebastiangb1.appfranquicias.controller;

import io.github.sebastiangb1.appfranquicias.common.ApiResponse;
import io.github.sebastiangb1.appfranquicias.models.Producto;
import io.github.sebastiangb1.appfranquicias.models.Sucursal;
import io.github.sebastiangb1.appfranquicias.service.ProductoService;
import io.github.sebastiangb1.appfranquicias.service.SucursalService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/{sucursal_id}")
    public ResponseEntity<ApiResponse> save(@PathVariable("sucursal_id") Long sucursal_id, @RequestBody Producto producto){
        Sucursal sucursal = sucursalService.findByID(sucursal_id);
        producto.setSucursal(sucursal);
        productoService.save(producto);
        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .message("Producto creado")
                .build());
    }

    @GetMapping("/{sucursal_id}")
    public ResponseEntity<ApiResponse> findBySucursal(@PathVariable("sucursal_id") Long sucursal_id){

        return ResponseEntity.ok(ApiResponse.builder().
                success(true)
                .data(productoService.findBySucursal(sucursal_id))
                .build());
    }

}
