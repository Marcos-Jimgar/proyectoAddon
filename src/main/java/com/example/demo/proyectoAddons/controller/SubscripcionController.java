package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Subscripcion;
import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.service.SubscripcionService;
import com.example.demo.proyectoAddons.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/subscripcion")
public class SubscripcionController {
@Autowired
private SubscripcionService subsService;

@PostMapping
public Subscripcion createPersona(@Valid @RequestBody Subscripcion subscripcion) {
return subsService.createSubscripcion(subscripcion);
}
@GetMapping
public List<Subscripcion> getSubscripciones() {
return subsService.getAll();
}

@DeleteMapping
public String borrarSusbcripcions() {
subsService.borra();
return  "Datos Borrados";
}

}