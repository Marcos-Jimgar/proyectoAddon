package com.example.demo.proyectoAddons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "creador_addon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreadorAddon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Creador
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "creador_id", nullable = false)
    private Creador creador;

    // Relación con Addon
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "addon_id", nullable = false)
    private Addon addon;

    //STATUS
    @Column(name = "status", length = 100)
    private String status;
}
