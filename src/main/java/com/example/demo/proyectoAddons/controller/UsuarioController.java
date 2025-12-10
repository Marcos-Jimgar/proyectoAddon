package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
@Autowired
private UsuarioService usuarioService;

@PostMapping
public Usuario createPersona(@Valid @RequestBody Usuario codBar) {
return usuarioService.createUsuario(codBar);
}

@GetMapping
public List<Usuario> getAllUsuarios() {
return usuarioService.getAllUsuarios();
}

@GetMapping("/{id}")
public boolean usuarioExiste(@PathVariable Long id) {
return usuarioService.usuarioExiste(id);
}

@DeleteMapping
public String borrarUsuarios() {
usuarioService.borrarUsuarios();
return  "Datos Borrados";
}

}