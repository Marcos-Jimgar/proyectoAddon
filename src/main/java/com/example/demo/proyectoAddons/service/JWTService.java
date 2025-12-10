package com.example.demo.proyectoAddons.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de la generación y validación de tokens JWT.
 */
@Service
public class JWTService {

    // Clave secreta usada para firmar los tokens
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Genera un token JWT con la información básica del usuario.
     * @param username Nombre del usuario
     * @param id ID del usuario (Long)
     * @return Token firmado en formato JWT
     */
    public String generarToken(String username, Long id) {
        long ahora = System.currentTimeMillis();
        long expiracion = 1000 * 60 * 60; // 1 hora de validez

        return Jwts.builder()
                .setSubject(username)
                .claim("id", id) // Agregamos la ID del usuario
                .setIssuedAt(new Date(ahora))
                .setExpiration(new Date(ahora + expiracion))
                .signWith(secretKey)
                .compact();
    }

    /**
     * Valida un token y devuelve el usuario asociado si es válido.
     * @param token Token JWT recibido
     * @return Nombre del usuario o null si no es válido
     */
    public String validarYObtenerUsuario(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return null; // token inválido o expirado
        }
    }

    /**
     * Obtiene la ID del usuario desde el token.
     * @param token Token JWT recibido
     * @return ID del usuario o null si no es válido
     */
    public Long obtenerId(String token) {
        try {
            return (Long) Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .get("id");
        } catch (Exception e) {
            return null; // token inválido o expirado
        }
    }
}
