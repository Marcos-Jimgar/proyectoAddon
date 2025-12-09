package com.example.demo.comentarioContenido.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.comentarioContenido.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;