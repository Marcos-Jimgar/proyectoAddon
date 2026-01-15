package com.example.demo.proyectoAddons.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "creador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Creador {

    @Id
    private Long id;

    @Column(name = "especialidad", nullable = false, length = 60)
    @NotBlank
    private String especialidad;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", unique = true)
    @JsonManagedReference(value = "creador-usuario")
    private Usuario usuario;

    // Un creador tiene muchas subscripciones
    @OneToMany(mappedBy = "creador")
    @JsonManagedReference(value = "creador-subs")
    private List<Subscripcion> subscripciones;

    @OneToMany(mappedBy = "creador")
    private List<CreadorAddon> creadorAddons;

}
