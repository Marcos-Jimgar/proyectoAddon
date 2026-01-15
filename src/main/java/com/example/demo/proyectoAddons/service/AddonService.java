package com.example.demo.proyectoAddons.service;

import com.example.demo.proyectoAddons.model.Addon;
import com.example.demo.proyectoAddons.model.Creador;
import com.example.demo.proyectoAddons.model.Subscripcion;
import com.example.demo.proyectoAddons.repository.AddonRepository;
import com.example.demo.proyectoAddons.repository.CreadorrRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddonService {

    @Autowired
    private AddonRepository addonRepository;

    @Autowired
    private CreadorrRepository creadorRepository;

    public Addon createAddon(Addon addonContent) {
        addonContent.setLikes(0);
        return addonRepository.save(addonContent); 
    }

    public List<Addon> getAlLAddons() {
        return addonRepository.findAll(); 
    }

    @Transactional
    public void linkAddonCreador(Long idCreador, Long idAddon, String status) {
        addonRepository.insertarCreadorAddon(idCreador,idAddon,status);
    } 

    @Transactional
    public List<String> getCreadorNombreDeUnAddon(Long idAddon) {
        //Devolver solo el nombre, si devuelo el objeto doy datos de mas.
        List<Creador> listaCreadoresObjeto = creadorRepository.findAllById(addonRepository.getRelacionesPorAddon(idAddon));
        List<String> listaCreadoresNombre = new ArrayList<>();

        for (Creador creadorAct : listaCreadoresObjeto) {
            listaCreadoresNombre.add(creadorAct.getUsuario().getNombre());
        }
        return listaCreadoresNombre;
    }

        @Transactional
    public List<Long> getCreadorIdDeUnAddon(Long idAddon) {
        //Devolver solo el nombre, si devuelo el objeto doy datos de mas.
        List<Creador> listaCreadoresObjeto = creadorRepository.findAllById(addonRepository.getRelacionesPorAddon(idAddon));
        List<Long> listaCreadoresNombre = new ArrayList<>();

        for (Creador creadorAct : listaCreadoresObjeto) {
            listaCreadoresNombre.add(creadorAct.getUsuario().getId());
        }
        return listaCreadoresNombre;
    }

}
