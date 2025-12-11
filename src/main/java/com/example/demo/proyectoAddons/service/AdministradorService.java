package com.example.demo.proyectoAddons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.proyectoAddons.model.Administrador;
import com.example.demo.proyectoAddons.model.Creador;
import com.example.demo.proyectoAddons.repository.AdministradorRepository;

import jakarta.validation.Valid;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador createAdministrador(Administrador administrador) {
        administrador.setId(administrador.getUsuario().getId()); // Asigno la Id Del usuario al admin
        return administradorRepository.save(administrador);
    }

    public List<Administrador> getAll() {
        return administradorRepository.findAll();
    }

    public String borra() {
        administradorRepository.deleteAll();
        return "Datos Borrados";
    }

    public boolean adminsitradorExiste(Long id) {
        return administradorRepository.findById(id).isPresent();
    }

    public Administrador devolverAdminsitrador(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

}
