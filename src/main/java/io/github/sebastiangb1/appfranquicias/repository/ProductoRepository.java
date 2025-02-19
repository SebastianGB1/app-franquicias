package io.github.sebastiangb1.appfranquicias.repository;

import io.github.sebastiangb1.appfranquicias.dto.DTOProductoMaxStock;
import io.github.sebastiangb1.appfranquicias.models.Producto;
import io.github.sebastiangb1.appfranquicias.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findBySucursal(Sucursal sucursal);

    @Query("""
            SELECT new io.github.sebastiangb1.appfranquicias.dto.DTOProductoMaxStock(s.nombre, p.nombre, p.stock) 
            FROM Producto p
            JOIN p.sucursal s
            JOIN s.franquicia f
            WHERE f.id = :franquiciaId
            AND p.stock = (
                SELECT MAX(p2.stock) 
                FROM Producto p2 
                WHERE p2.sucursal.id = s.id
            )
            """)
    List<DTOProductoMaxStock> findMaxStockProductsByFranquicia(@Param("franquiciaId") Long franquiciaId);
}
