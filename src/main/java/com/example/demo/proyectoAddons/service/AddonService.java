package com.example.demo.proyectoAddons.service;

import com.example.demo.proyectoAddons.model.Addon;
import com.example.demo.proyectoAddons.model.Creador;
import com.example.demo.proyectoAddons.model.Subscripcion;
import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.repository.AddonRepository;
import com.example.demo.proyectoAddons.repository.CreadorrRepository;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddonService {

    @Autowired
    private AddonRepository addonRepository;

    @Autowired
    private CreadorrRepository creadorRepository;

    @Autowired
    private UsuarioLikeService usuarioLikeService;

    public Addon createAddon(Addon addonContent) {
        addonContent.setLikes(0);
        return addonRepository.save(addonContent);
    }

    public Addon devolverAddon(Long id) {
        return addonRepository.findById(id).orElse(null);
    }

    public List<Addon> getAlLAddons() {
        return addonRepository.findAll();
    }

    public boolean addonExiste(Long id) {
    return addonRepository.findById(id).isPresent();
    }

    public Boolean darLike(Long idAddon, Long idUsuario) {
    Optional<Addon> addonAct = addonRepository.findById(idAddon);

    //Consulta si se ha dado like
    if (!usuarioLikeService.createLikeLink(idUsuario, this.devolverAddon(idAddon))) {
        return false;
    }

    //el ispresent es por el Optional, lo necesitamos para que no pete en caso de null.
    if (addonAct.isPresent()) {
        Addon addon = addonAct.get();

        if (addon.getLikes() == null) {
            addon.setLikes(1);
        } else {
            addon.setLikes(addon.getLikes() + 1);
        }

        addonRepository.save(addon);
    }
    return true;
}


    @Transactional
    public void linkAddonCreador(Long idCreador, Long idAddon, String status) {
        //RESET POR SI ES RECHAZADO
        addonRepository.deleteDatosDeCreadorAddon(idCreador,idAddon);

        addonRepository.insertarCreadorAddon(idCreador, idAddon, status);
    }

        @Transactional
    public void actualizarStatusCreadorAddon(Long idCreador, Long idAddon, String status) {
        addonRepository.actualizarStatusCreadorAddon(idCreador, idAddon, status);
    }

    @Transactional
    public List<String> getCreadorNombreDeUnAddon(Long idAddon) {
        // Devolver solo el nombre, si devuelo el objeto doy datos de mas.
        List<Creador> listaCreadoresObjeto = creadorRepository
                .findAllById(addonRepository.getRelacionesPorAddon(idAddon));
        List<String> listaCreadoresNombre = new ArrayList<>();

        for (Creador creadorAct : listaCreadoresObjeto) {
            listaCreadoresNombre.add(creadorAct.getUsuario().getNombre());
        }
        return listaCreadoresNombre;
    }

    public boolean esCreadorOriginal(Long idCreador, Long idAddon) {
        boolean esCreadorOriginal = false;
        for (String variable : addonRepository.getAddonsCreado(idAddon,idCreador)) {
            if (variable.equals("creador"))  esCreadorOriginal = true;
        }
        return esCreadorOriginal;
    }

        public boolean esCreadorInvitado(Long idCreador, Long idAddon) {
        boolean esCreadorInvitado = false;
        for (String variable : addonRepository.getAddonsCreado(idAddon,idCreador)) {
            if (variable.equals("pendiente") || variable.equals("colaborador"))  esCreadorInvitado = true;
        }
        return esCreadorInvitado;
    }

    public List<Addon> getAddonsDeCreador(Long idCreador) {
        List<Addon> listadEAddonsPropios = new ArrayList<>();
        for (Long addonid : addonRepository.getAddonsDeCreador(idCreador)) {
            //Esto permite añadir a la lista los addons SOLO por la id.
            addonRepository.findById(addonid).ifPresent(listadEAddonsPropios::add);
        }

        return listadEAddonsPropios;
    }

        public List<Addon> getAddonsDeCreadorPendiente(Long idCreador) {
        List<Addon> listadEAddonsPropios = new ArrayList<>();
        for (Long addonid : addonRepository.getAddonsDeCreadorPendiente(idCreador)) {
            addonRepository.findById(addonid).ifPresent(listadEAddonsPropios::add);
        }

        return listadEAddonsPropios;
    }
}
