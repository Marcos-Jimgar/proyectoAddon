package com.example.demo.proyectoAddons.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.proyectoAddons.model.Subscripcion;
import com.example.demo.proyectoAddons.repository.SubscripcionRepository;

import jakarta.validation.Valid;

@Service
public class SubscripcionService {

    @Autowired
    private SubscripcionRepository subscripcionRepository;

    public Subscripcion createSubscripcion(Subscripcion sub1) {
        return subscripcionRepository.save(sub1);
    }


    public List<Subscripcion> getAll() {
        return subscripcionRepository.findAll();
    }

    public String borra() {
        subscripcionRepository.deleteAll();
        return "Datos Borrados";
    }


}
