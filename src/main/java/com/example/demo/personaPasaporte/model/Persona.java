package com.example.demo.personaPasaporte.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @Column(name = "dni", nullable = false, unique = true, length = 9)
    @NotBlank
    @Length(min = 8, max = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 60)
    @NotBlank
    @Length(min = 2, max = 60)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "numero_pasaporte", referencedColumnName = "numero_pasaporte", unique = true)
    @JsonManagedReference
    private Pasaporte pasaporte;
}
