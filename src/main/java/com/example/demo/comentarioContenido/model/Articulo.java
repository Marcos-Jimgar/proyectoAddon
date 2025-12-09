package com.example.demo.comentarioContenido.model;

import org.hibernate.validator.constraints.Length;

import com.example.demo.personaPasaporte.model.Pasaporte;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {

    @Id
    @Column(name = "titulo", nullable = false, unique = true)
    @NotBlank
    @Length(min = 15, max = 120)
    private String titulo;

    @Column(name = "contenido", nullable = false)
    @NotBlank
    @Length(min = 20, max = 4000)
    private String contenido;

    @Column(name = "fecha_publicacion", nullable = false)
    @NotBlank
    private String fechaPublicacion;
}
