package com.example.demo.proyectoAddons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.proyectoAddons.model.Administrador;


public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;