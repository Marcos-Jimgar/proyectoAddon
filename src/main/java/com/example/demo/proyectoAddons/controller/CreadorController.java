package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Creador;

import com.example.demo.proyectoAddons.service.CreadorService;
import com.example.demo.proyectoAddons.service.JWTService;
import com.example.demo.proyectoAddons.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/creador")
public class CreadorController {
    @Autowired
    private CreadorService creadorService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UsuarioService usuarioService ;


    @PostMapping()
    public ResponseEntity<?> createCreador(
            @RequestHeader(name = "Authorization", required = false) String authHeader) {

        Long userId = jwtService.obtenerId(authHeader);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }
        Creador creadorAct = new Creador();
        creadorAct.setUsuario(usuarioService.devolverUsuario(userId));       
        //Luego el usuario podras especificar su especialidad
        creadorAct.setEspecialidad("ninguno");
        creadorService.createCreador(creadorAct);
        return ResponseEntity.ok("Has Pasado A Ser Creador");
    }

}