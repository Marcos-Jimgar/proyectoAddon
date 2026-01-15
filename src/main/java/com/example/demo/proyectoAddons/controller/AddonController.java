package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Addon;
import com.example.demo.proyectoAddons.model.Creador;
import com.example.demo.proyectoAddons.service.AddonService;
import com.example.demo.proyectoAddons.service.CreadorService;
import com.example.demo.proyectoAddons.service.JWTService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/addon")
public class AddonController {
    @Autowired
    private AddonService addonService;
    @Autowired
    private CreadorService creadorService;
    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity<?> createAddon(@RequestHeader(name = "Authorization", required = false) String authHeader,
            @Valid @RequestBody Addon addonContent) {

        Long userId = jwtService.obtenerId(authHeader);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }

        if (!creadorService.creadorExiste(userId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "No eres un Creador"));
        }
    
        Addon addonCreado = addonService.createAddon(addonContent);
        addonService.linkAddonCreador(userId, addonCreado.getId());
        return ResponseEntity.ok(addonCreado);
    }

    @GetMapping
    public List<Addon> gettAllAddons() {
        return addonService.getAlLAddons();
    }

    @GetMapping("creadores/{idAddon}")
    public List<String> getCreadorNombreDeUnAddon(@PathVariable Long idAddon) {
        return addonService.getCreadorNombreDeUnAddon(idAddon);
    }

}