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
@Table(name = "comentario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "autor", nullable = false)
    @NotBlank
    @Length(min = 2, max = 180)
    private String autor;

    @Column(name = "contenido", nullable = false)
    @NotBlank
    @Length(min = 3, max = 500)
    private String contenido;

    @Column(name = "fecha_comentario", nullable = false)
    @NotBlank
    private String fechaComentario;
    
    @ManyToOne
    @JoinColumn(name = "titulo", referencedColumnName = "titulo")
    @JsonManagedReference
    private Articulo articulo;
}
