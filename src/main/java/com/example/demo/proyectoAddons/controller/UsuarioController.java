package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.service.JWTService;
import com.example.demo.proyectoAddons.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public Usuario createUsuario(@Valid @RequestBody Usuario codBar) {
        return usuarioService.createUsuario(codBar);
    }

    @GetMapping("")
    public ResponseEntity<?> VerInfo(
            @RequestHeader(name = "Authorization", required = false) String authHeader) {

        Long userId = jwtService.obtenerId(authHeader);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }
        
        return ResponseEntity.ok(usuarioService.devolverUsuario(userId));
    }

    //cualquier usuario puede ver si otro usuario existe
    @GetMapping("/{id}")
    public boolean usuarioExiste(@PathVariable Long id) {
        return usuarioService.usuarioExiste(id);
    }

}