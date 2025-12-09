package com.example.demo.comentarioContenido.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.comentarioContenido.model.Articulo;
import com.example.demo.comentarioContenido.repository.ArticuloRepository;


import jakarta.validation.Valid;

@Service
public class ArticuloService {

    @Autowired

    private ArticuloRepository articuloRepository;


    public Articulo createArticulo(Articulo art) {
        return articuloRepository.save(art);
    }

    public List<Articulo> getArticulos() {
        return articuloRepository.findAll();
    }

    public String borra() {
        articuloRepository.deleteAll();
        return "Datos Borrados";
    }


}
