package com.example.demo.codigoBarras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cod_bars")
public class CodigoBarraController {
@Autowired
private CodigoBarraService codigoBarraService;
@PostMapping
public CodigoBarra createBarra(@Valid @RequestBody CodigoBarra codBar) {
return codigoBarraService.createBarra(codBar);
}
@GetMapping
public List<CodigoBarra> getBarra() {
return codigoBarraService.getBarra();
}

@DeleteMapping
public String borra() {
codigoBarraService.borra();
return  "Datos Borrados";
}

}