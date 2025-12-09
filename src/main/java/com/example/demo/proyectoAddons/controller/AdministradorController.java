package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Administrador;
import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.service.AdministradorService;
import com.example.demo.proyectoAddons.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
@Autowired
private AdministradorService administradorService;

@PostMapping
public Administrador createPersona(@Valid @RequestBody Administrador admin1) {
return administradorService.createAdministrador(admin1);
}
@GetMapping
public List<Administrador> getDni() {
return administradorService.getAll();
}

@DeleteMapping
public String borra() {
administradorService.borra();
return  "Datos Borrados";
}

}