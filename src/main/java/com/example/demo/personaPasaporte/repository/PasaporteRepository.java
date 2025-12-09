package com.example.demo.personaPasaporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.personaPasaporte.model.Pasaporte;

public interface PasaporteRepository extends JpaRepository<Pasaporte, String> {

    // Método para encontrar el pasaporte por su número
    Pasaporte findByNumeroPasaporte(String numeroPasaporte);

}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;