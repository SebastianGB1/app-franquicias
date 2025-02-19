package io.github.sebastiangb1.appfranquicias.controller;

import io.github.sebastiangb1.appfranquicias.common.ApiResponse;
import io.github.sebastiangb1.appfranquicias.dto.DTOAgregarSucursalAFranquicia;
import io.github.sebastiangb1.appfranquicias.models.Franquicia;
import io.github.sebastiangb1.appfranquicias.models.Sucursal;
import io.github.sebastiangb1.appfranquicias.service.FranquiciaService;
import io.github.sebastiangb1.appfranquicias.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private FranquiciaService franquiciaService;

    @GetMapping
    public ResponseEntity<ApiResponse> obtenerSucursales() {
        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .data(sucursalService.findAll())
                .build());
    }

    @PostMapping("/addSucursalAFranquicia")
    public ResponseEntity<ApiResponse> agregarSucursalAFranquicia(@RequestBody DTOAgregarSucursalAFranquicia datos) {
        Franquicia franquicia = franquiciaService.findByID(datos.getIdFranquicia());

            Sucursal sucursal = new Sucursal();
            sucursal.setNombre(datos.getNombreSucursal());
            sucursal.setFranquicia(franquicia);
            sucursalService.saveSucursal(sucursal);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .message("Sucursal agregada")
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizarSucursal(@PathVariable("id") Long id, @RequestBody Sucursal sucursal) {
        sucursalService.update(id, sucursal);
        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .message("Sucursal actualizada")
                .build());
    }
}