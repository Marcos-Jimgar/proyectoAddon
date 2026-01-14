package com.example.demo.proyectoAddons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.proyectoAddons.model.Subscripcion;

public interface SubscripcionRepository extends JpaRepository<Subscripcion, Long> {

}

//sudo -u postgres  psql
// \c mydb 
// SELECT * FROM TABLE;