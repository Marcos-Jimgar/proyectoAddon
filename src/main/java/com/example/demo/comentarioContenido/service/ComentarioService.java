package com.example.demo.comentarioContenido.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.comentarioContenido.model.Articulo;
import com.example.demo.comentarioContenido.model.Comentario;
import com.example.demo.comentarioContenido.repository.ArticuloRepository;
import com.example.demo.comentarioContenido.repository.ComentarioRepository;

import jakarta.validation.Valid;

@Service
public class ComentarioService {

    @Autowired

    private ComentarioRepository comentepository;


    public Comentario createComentario(Comentario comt) {
        return comentepository.save(comt);
    }

    public List<Comentario> getComentarios() {
        return comentepository.findAll();
    }

    public String borra() {
        comentepository.deleteAll();
        return "Datos Borrados";
    }


}
