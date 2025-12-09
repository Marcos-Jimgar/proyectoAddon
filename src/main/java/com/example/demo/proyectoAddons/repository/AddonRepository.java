package com.example.demo.proyectoAddons.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.proyectoAddons.model.Addon;

public interface AddonRepository extends JpaRepository<Addon, Long> {

}

//sudo -u postgres  psql
// \c mydb 
// SELECT * FROM TABLE;