package com.example.demo.comentarioContenido.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.comentarioContenido.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, String> {

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;