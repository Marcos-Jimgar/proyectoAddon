package com.example.demo.comentarioContenido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.comentarioContenido.model.Articulo;
import com.example.demo.comentarioContenido.service.ArticuloService;
import com.example.demo.personaPasaporte.model.Pasaporte;
import com.example.demo.personaPasaporte.model.Persona;
import com.example.demo.personaPasaporte.repository.PasaporteRepository;
import com.example.demo.personaPasaporte.service.PasaporteService;
import com.example.demo.personaPasaporte.service.PersonaService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulo")
public class ArticuloController {
@Autowired
private ArticuloService artService;

@PostMapping
public Articulo createArticulo(@Valid @RequestBody Articulo art) {
    return artService.createArticulo(art);
}


@GetMapping
public List<Articulo> getComentarios() {
return artService.getArticulos();
}

@DeleteMapping
public String borra() {
artService.borra();
return  "Datos Borrados";
}

}