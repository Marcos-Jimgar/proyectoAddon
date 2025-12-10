package com.example.demo.proyectoAddons.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.proyectoAddons.model.Usuario;
import com.example.demo.proyectoAddons.service.JWTService;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JWTService jwtService;

    public AuthController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    //EVENTUALMENTE CAPAR LOS CONTROLLERS

    //Valida las credenciales y devuelve un token JWT si son correctas.
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario req) {

        String passUser = null;
        // Lógica adaptada para validar las credenciales de los usuarios. (principal, mirar contraseña)

        // Ejemplo de validación de usuario (se debe adaptar a tu lógica de usuarios).
        // if (mapaUsuarios.containsKey(req.getUser()))
        //     passUser = mapaUsuarios.get(req.getUser()).getPassword();

        // if (!mapaUsuarios.containsKey(req.getUser()) || !req.getPassword().equals(passUser)) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Credenciales inválidas"));
        // }

        Long usuarioId = req.getId();
        String username = req.getNombre();


        String token = jwtService.generarToken(username, usuarioId);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "tipo", "Bearer",
                "expiracion", "1 hora"));
    }

    //Elimina el token.
    @GetMapping("/removerJWT")
    public ResponseEntity<?> remover(@RequestHeader(name = "Authorization", required = false) String authHeader) {
        
        return ResponseEntity.ok(Map.of("respuesta", "Token Borrado"));
    }

    // Renueva el token JWT. Valida el token y genera uno nuevo.
    @GetMapping("/renovarJWT")
    public ResponseEntity<?> renovar(@RequestHeader(name = "Authorization", required = false) String authHeader) {
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Token no proporcionado o formato incorrecto"));
        }

        String token = authHeader.substring(7); // Elimina el prefijo "Bearer "
        String usuario = jwtService.validarYObtenerUsuario(token);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Token inválido o expirado"));
        }

        Long usuarioId = jwtService.obtenerId(token);

        String nuevaToken = jwtService.generarToken(usuario, usuarioId);

        return ResponseEntity.ok(Map.of("token", nuevaToken));
    }
}
