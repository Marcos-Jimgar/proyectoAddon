package com.example.demo.personaPasaporte.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.personaPasaporte.model.Pasaporte;
import com.example.demo.personaPasaporte.model.Persona;
import com.example.demo.personaPasaporte.repository.PasaporteRepository;
import com.example.demo.personaPasaporte.repository.PersonaRepository;

import jakarta.validation.Valid;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired

    private PasaporteRepository pasaPersonaRepository;


    public Persona createPersona(Persona persona) {
    Pasaporte pasaporte = pasaPersonaRepository.findByNumeroPasaporte(persona.getPasaporte().getNumeroPasaporte());
    if (pasaporte == null) {
        throw new RuntimeException("Pasaporte con número " + persona.getPasaporte().getNumeroPasaporte() + " no encontrado.");
    }
    persona.setPasaporte(pasaporte);
    return personaRepository.save(persona);
    }



    public List<Persona> getDni() {
        return personaRepository.findAll();
    }

    public String borra() {
        personaRepository.deleteAll();
        return "Datos Borrados";
    }


}
