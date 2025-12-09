package com.example.demo.proyectoAddons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.proyectoAddons.model.Creador;


public interface CreadorrRepository extends JpaRepository<Creador, Long> {

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;