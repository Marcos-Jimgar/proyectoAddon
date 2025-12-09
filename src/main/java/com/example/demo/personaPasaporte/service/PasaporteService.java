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
public class PasaporteService {

    @Autowired

    private PasaporteRepository pasaPersonaRepository;


    public Pasaporte createPasaporte(Pasaporte codBar) {
        return pasaPersonaRepository.save(codBar);
    }

    public List<Pasaporte> getNumeroPasaporte() {
        return pasaPersonaRepository.findAll();
    }

    public String borra() {
        pasaPersonaRepository.deleteAll();
        return "Datos Borrados";
    }


}
