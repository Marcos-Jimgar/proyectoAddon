package com.example.demo.personaPasaporte.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.personaPasaporte.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;