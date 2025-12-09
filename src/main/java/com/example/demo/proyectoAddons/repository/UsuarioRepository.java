package com.example.demo.proyectoAddons.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.proyectoAddons.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;