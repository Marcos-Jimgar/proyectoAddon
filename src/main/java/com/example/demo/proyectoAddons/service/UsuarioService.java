package com.example.demo.proyectoAddons.service;

import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;  // Debes inyectar el repositorio, no la entidad

    public Usuario createUsuario(Usuario usuario) {
        // Lógica para crear un Usuario
        return usuarioRepository.save(usuario); // Usamos el repositorio para guardar la entidad
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll(); // Devuelve todos los usuarios
    }

    public void borrarUsuarios() {
        usuarioRepository.deleteAll(); // Borra todos los usuarios
    }
}
