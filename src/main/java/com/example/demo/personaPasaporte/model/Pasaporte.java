package com.example.demo.personaPasaporte.model;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data; // Importa Lombok

@Entity
@Table(name = "pasaporte")
@Data // Añade esta anotación
public class Pasaporte {
    @Id
    @Column(name = "numero_pasaporte", nullable = false, unique = true, length = 15)
    @Size(min = 5, max = 15)
    @NotBlank
    private String numeroPasaporte;

    @Column(name = "pais", length = 3)
    @Length(min = 3, max = 3)
    private String pais;
    
}
