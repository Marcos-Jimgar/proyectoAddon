package com.example.demo.codigoBarras;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@Service
public class CodigoBarraService {

    @Autowired
    private CodigoBarraRepository codigoBarraRepository;

    public CodigoBarra createBarra(CodigoBarra codBar) {
        return codigoBarraRepository.save(codBar);
    }

    public List<CodigoBarra> getBarra() {
        return codigoBarraRepository.findAll();
    }

    public String borra() {
        codigoBarraRepository.deleteAll();
        return "Datos Borrados";
    }

    //SELECT * FROM TABLE WHERE TABLE.MARCA = MARCA;
    public List<CodigoBarra> findByMarca(String brand) {
        return codigoBarraRepository.findByMarca(brand);
    }

    //SELECT * FROM TABLE WHERE TABLE.PRECIO > precio;
    public List<CodigoBarra> findByPrecioGreaterThanEqual(Double precio) {
        return codigoBarraRepository.findByPrecioGreaterThanEqual(precio);
    }

    //SELECT * FROM TABLE WHERE TABLE.MARCA = "%MARCA%";
    public List<CodigoBarra> findByDescripcionContainingIgnoreCase(String texto) {  
        return codigoBarraRepository.findByDescripcionContainingIgnoreCase(texto);
    }
}
