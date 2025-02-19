package io.github.sebastiangb1.appfranquicias.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private Franquicia franquicia;

}
