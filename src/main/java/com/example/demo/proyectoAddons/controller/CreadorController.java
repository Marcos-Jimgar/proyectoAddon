package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.proyectoAddons.model.Creador;

import com.example.demo.proyectoAddons.service.CreadorService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/creador")
public class CreadorController {
@Autowired
private CreadorService creadorService;

@PostMapping
public Creador createPersona(@Valid @RequestBody Creador creador1) {
return creadorService.createCreador(creador1);
}
@GetMapping
public List<Creador> getCreadores() {
return creadorService.getAll();
}

@DeleteMapping
public String borra() {
creadorService.borra();
return  "Datos Borrados";
}

}