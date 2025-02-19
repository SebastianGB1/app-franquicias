package io.github.sebastiangb1.appfranquicias.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;
}
