package io.github.sebastiangb1.appfranquicias.controller;

import io.github.sebastiangb1.appfranquicias.common.ApiResponse;
import io.github.sebastiangb1.appfranquicias.dto.DTOProductoMaxStock;
import io.github.sebastiangb1.appfranquicias.models.Franquicia;
import io.github.sebastiangb1.appfranquicias.repository.ProductoRepository;
import io.github.sebastiangb1.appfranquicias.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> guardarFranquicia(@RequestBody Franquicia franquicia) {
        franquiciaService.save(franquicia);
        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .message("Franquicia creada")
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> guardarFranquicia(@PathVariable("id") Long id, @RequestBody Franquicia franquicia) {
        franquiciaService.update(id, franquicia);
        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .message("Franquicia actualizada")
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse> obtenerFranquicias() {
        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .data(franquiciaService.findAll())
                .build());
    }

    @GetMapping("/{franquiciaId}/productos-max-stock")
    public ResponseEntity<List<DTOProductoMaxStock>> obtenerProductosConMasStock(@PathVariable Long franquiciaId) {
        List<DTOProductoMaxStock> productos = productoRepository.findMaxStockProductsByFranquicia(franquiciaId);
        return ResponseEntity.ok(productos);
    }

}
