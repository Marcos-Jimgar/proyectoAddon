package com.example.demo.comentarioContenido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.comentarioContenido.model.Articulo;
import com.example.demo.comentarioContenido.model.Comentario;
import com.example.demo.comentarioContenido.service.ArticuloService;
import com.example.demo.comentarioContenido.service.ComentarioService;
import com.example.demo.personaPasaporte.model.Pasaporte;
import com.example.demo.personaPasaporte.model.Persona;
import com.example.demo.personaPasaporte.repository.PasaporteRepository;
import com.example.demo.personaPasaporte.service.PasaporteService;
import com.example.demo.personaPasaporte.service.PersonaService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {
@Autowired
private ComentarioService comentarioService;

@PostMapping
public Comentario createComentario(@Valid @RequestBody Comentario art) {
    return comentarioService.createComentario(art);
}


@GetMapping
public List<Comentario> getComentarios() {
return comentarioService.getComentarios();
}

@DeleteMapping
public String borra() {
comentarioService.borra();
return  "Datos Borrados";
}

}