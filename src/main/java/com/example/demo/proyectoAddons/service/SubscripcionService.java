package com.example.demo.proyectoAddons.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.proyectoAddons.model.Creador;
import com.example.demo.proyectoAddons.model.Subscripcion;
import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.repository.SubscripcionRepository;

import jakarta.validation.Valid;

@Service
public class SubscripcionService {

    @Autowired
    private SubscripcionRepository subscripcionRepository;
    private CreadorService creadorService;
    private UsuarioService usuarioService;

    public Subscripcion createSubscripcion(Subscripcion sub1) {
        return subscripcionRepository.save(sub1);
    }

    public boolean createSubscripcion(Long idCreador, Long idUsuario) {
        Subscripcion sub1 = null;
        Usuario usu1 = usuarioService.devolverUsuario(idUsuario);
        Creador cre1 = creadorService.devolverCreador(idCreador);

        sub1.setNotificar(false);

        if (usu1 !=null && cre1 !=null) {
            sub1.setUsuario(usu1);
            sub1.setCreador(cre1);
            this.createSubscripcion(sub1);
            return true;
        }
        
        return false;
    }

    public List<Subscripcion> getAll() {
        return subscripcionRepository.findAll();
    }

    public String borra() {
        subscripcionRepository.deleteAll();
        return "Datos Borrados";
    }


}
