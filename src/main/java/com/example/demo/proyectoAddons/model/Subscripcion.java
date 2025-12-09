package com.example.demo.proyectoAddons.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "subscripcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscripcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscripcion_id;

    private boolean notificar;

    // Muchas suscripciones pertenecen a un creador
    @ManyToOne
    @JoinColumn(name = "creador_id")
    @JsonBackReference(value = "creador-subs")
    private Creador creador;

    // Muchas suscripciones pertenecen a un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference(value = "usuario-subs")
    private Usuario usuario;
}
