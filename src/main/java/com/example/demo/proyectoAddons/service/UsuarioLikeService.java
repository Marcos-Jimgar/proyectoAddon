package com.example.demo.proyectoAddons.service;


import java.util.List;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.proyectoAddons.model.Addon;
import com.example.demo.proyectoAddons.model.UsuarioLike;
import com.example.demo.proyectoAddons.repository.UsuarioLikeRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioLikeService {

    @Autowired
    private UsuarioLikeRepository usuarioLikeRepository;

    @Autowired
    private UsuarioService usuarioService;
    
    public Boolean createLikeLink(Long idUser, Addon addon) {
    UsuarioLike instanciaDeLike = new UsuarioLike();
    instanciaDeLike.setAddon(addon);
    instanciaDeLike.setUsuario(usuarioService.devolverUsuario(idUser));
    instanciaDeLike.setId(idUser + " " + addon.getId());

    int likeCount = usuarioLikeRepository.getSiDarLike(idUser, addon.getId());
    if (likeCount == 0) {
        usuarioLikeRepository.save(instanciaDeLike);
        return true;
    }

    return false;
}


}
