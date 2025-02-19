package io.github.sebastiangb1.appfranquicias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOProductoMaxStock {
    private String sucursal;
    private String producto;
    private int stock;

}
