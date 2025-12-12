package com.example.demo.proyectoAddons.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", unique = true)
    @JsonManagedReference(value = "admin-usuario")
    private Usuario usuario;
}
