package com.example.demo.proyectoAddons.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.proyectoAddons.model.Creador;

import com.example.demo.proyectoAddons.repository.CreadorrRepository;


import jakarta.validation.Valid;

@Service
public class CreadorService {

    @Autowired
    private CreadorrRepository creadorRepository;

    public Creador createCreador(Creador creador) {
        creador.setId(creador.getUsuario().getId());
        return creadorRepository.save(creador);
    }


    public List<Creador> getAll() {
        return creadorRepository.findAll();
    }

    public String borra() {
        creadorRepository.deleteAll();
        return "Datos Borrados";
    }


}
