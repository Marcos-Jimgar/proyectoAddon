package com.example.demo.proyectoAddons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Creador;
import com.example.demo.proyectoAddons.model.Subscripcion;
import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.service.CreadorService;
import com.example.demo.proyectoAddons.service.JWTService;
import com.example.demo.proyectoAddons.service.SubscripcionService;
import com.example.demo.proyectoAddons.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/subscripcion")
public class SubscripcionController {
    @Autowired
    private SubscripcionService subsService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CreadorService creadorService;
    @Autowired
    private JWTService jwtService;


@PostMapping("/susbscribe/{idCreador}")
public ResponseEntity<?> createSubscripcion(@RequestHeader(name = "Authorization", required = false) String authHeader,@PathVariable Long idCreador) {
    
    Long userId = jwtService.obtenerId(authHeader);
    Creador creadoraSuscribir = creadorService.devolverCreador(idCreador);
    Usuario nuevoSubscriptor = usuarioService.devolverUsuario(userId);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }
        
        if (creadoraSuscribir == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Creador No Valido"));
        }

    Subscripcion objSubs = new Subscripcion();
        objSubs.setNotificar(false);
        objSubs.setCreador(creadoraSuscribir);
        objSubs.setUsuario(nuevoSubscriptor);

    return ResponseEntity.ok(subsService.createSubscripcion(objSubs));
}

    @GetMapping("/subscritos")
    public ResponseEntity<?> verSubscripciones(@RequestHeader(name = "Authorization", required = false) String authHeader) {
    
        Long userId = jwtService.obtenerId(authHeader);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }

        return ResponseEntity.ok(subsService.getSubscribidos(userId));
    }


    @PutMapping("modificar/{idCreador}")
    public ResponseEntity<?> modificarNotificaciones(@RequestHeader(name = "Authorization", required = false) String authHeader,@PathVariable Long idCreador) {
        
        Long userId = jwtService.obtenerId(authHeader);
        Creador creador = creadorService.devolverCreador(idCreador);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }

        if (creador == null || !(subsService.getSubscribidos(userId).contains(creador))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Creador No Valido"));
        }

        boolean respuesta =  subsService.modificarNotificaciones(subsService.getSubcripcionID(idCreador, userId));

        return ResponseEntity.ok(Map.of("respuesta","Subscripcion alterada"));
    }

}