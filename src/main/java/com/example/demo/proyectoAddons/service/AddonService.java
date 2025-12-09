package com.example.demo.proyectoAddons.service;

import com.example.demo.proyectoAddons.model.Addon;
import com.example.demo.proyectoAddons.repository.AddonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddonService {

    @Autowired
    private AddonRepository addonRepository;

    public Addon createAddon(Addon addonContent) {
        return addonRepository.save(addonContent); 
    }

    public List<Addon> getAlLAddons() {
        return addonRepository.findAll(); 
    }

    public void borrarAddons() {
        addonRepository.deleteAll(); // Borra todos los Addons
    }
}
