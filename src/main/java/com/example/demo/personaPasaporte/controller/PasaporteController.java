package com.example.demo.personaPasaporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.personaPasaporte.model.Pasaporte;
import com.example.demo.personaPasaporte.model.Persona;
import com.example.demo.personaPasaporte.repository.PasaporteRepository;
import com.example.demo.personaPasaporte.service.PasaporteService;
import com.example.demo.personaPasaporte.service.PersonaService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pasaporte")
public class PasaporteController {
@Autowired
private PasaporteService pasaporteService;

@PostMapping
public Pasaporte createPasaporte(@Valid @RequestBody Pasaporte pasaporte) {
    return pasaporteService.createPasaporte(pasaporte);
}


@GetMapping
public List<Pasaporte> getNumeroPasaporte() {
return pasaporteService.getNumeroPasaporte();
}

@DeleteMapping
public String borra() {
pasaporteService.borra();
return  "Datos Borrados";
}

}