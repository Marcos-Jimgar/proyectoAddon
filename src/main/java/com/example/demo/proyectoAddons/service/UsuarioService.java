package com.example.demo.proyectoAddons.service;

import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; 
    public Usuario createUsuario(Usuario usuario) {
        
        return usuarioRepository.save(usuario); 
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll(); 
    }

    public void borrarUsuarios() {
        usuarioRepository.deleteAll(); // Borra todos los usuarios
    }

    public boolean usuarioExiste(Long id) {
    return usuarioRepository.findById(id).isPresent();
    }

    public Usuario devolverUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
     public Long devolverUsuarioPorCorreo(String correo) {
        Long id = null;
        for (Usuario userAct : this.getAllUsuarios()) {
            if (userAct.getEmail().equals(correo)) {
                id = userAct.getId();
            }
        }
        return id;
    }

    public boolean verificarUsuario(Usuario user) {
        boolean esVerficado = false;
        for (Usuario userAct : this.getAllUsuarios()) {
            if (user.getEmail().equals(userAct.getEmail()) && user.getPassword().equals(userAct.getPassword())) {
                esVerficado = true;
            }
        }
        return esVerficado;
    }

     public Integer totalUsuarios() {
        return usuarioRepository.totalUsuarios();
    }
}

