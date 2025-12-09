package com.example.demo.codigoBarras;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data; // Importa Lombok

@Entity
@Table(name = "codigos_barras")
@Data // Añade esta anotación
public class CodigoBarra {
    @Id
    @Min(value = 0, message = "tiene que ser mayor a 0")
    @Column(name = "codigo", nullable = false, unique = true, length = 50) //name es el nombre de la columna en la tabla
    @NotBlank
    private Long codigo;

    @Column(name = "descripcion", nullable = false)
    @NotBlank
    private String descripcion;

    @Column(name = "marca", nullable = false)
    @NotBlank
    private String marca;
    
    @DecimalMin(value = "0.0", message = "tiene que ser mayor a 0", inclusive = true)
    @NotBlank
    @Column(name = "precio", nullable = false)
    private double precio;
}
