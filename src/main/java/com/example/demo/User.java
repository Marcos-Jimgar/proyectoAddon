


package com.example.demo;

import jakarta.persistence.*;
import lombok.Data; // Importa Lombok


@Entity
@Table(name = "users")
@Data // Añade esta anotación
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    // Con Lombok no se necesita escribir manualmente los Getters y Setters
    /*// Getters y Setters:
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; } */
}
