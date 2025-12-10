package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Addon;
import com.example.demo.proyectoAddons.service.AddonService;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/addon")
public class AddonController {
@Autowired
private AddonService addonService;

@PostMapping
public Addon createPersona(@Valid @RequestBody Addon addonContent) {
return addonService.createAddon(addonContent);
}
@GetMapping
public List<Addon> getAllUsuarios() {
return addonService.getAlLAddons();
}

@DeleteMapping
public String borrarAddons() {
addonService.borrarAddons();
return  "Datos Borrados";
}

}