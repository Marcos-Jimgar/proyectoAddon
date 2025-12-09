package com.example.demo.personaPasaporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.personaPasaporte.model.Persona;
import com.example.demo.personaPasaporte.service.PersonaService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
@Autowired
private PersonaService personaService;

@PostMapping
public Persona createPersona(@Valid @RequestBody Persona codBar) {
return personaService.createPersona(codBar);
}
@GetMapping
public List<Persona> getDni() {
return personaService.getDni();
}

@DeleteMapping
public String borra() {
personaService.borra();
return  "Datos Borrados";
}

}