package com.example.demo.proyectoAddons.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "addon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 60)
    @NotBlank
    @Length(min = 2, max = 60)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    @NotBlank
    private String tipo;

    @Column(name = "url_miniatura", nullable = false)
    @NotBlank
    private String urlMiniatura;

    @Column(name = "descripcion", nullable = false)
    @NotBlank
    @Length(min = 100, max = 1000)
    private String descripcion;

    @Column(name = "likes")
    private Integer likes = 0;

    @ManyToMany(mappedBy = "addons")
    @JsonBackReference
    private List<Creador> creadores;
}
