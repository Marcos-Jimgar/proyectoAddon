package com.example.demo.codigoBarras;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CodigoBarraRepository extends JpaRepository<CodigoBarra, Long> {
List<CodigoBarra> findByMarca(String marca);
List<CodigoBarra> findByPrecioGreaterThanEqual(Double precio);
List<CodigoBarra> findByDescripcionContainingIgnoreCase(String descripcion);
}

//sudo -u postgres  psql
// \c mybd 
// SELECT * FROM TABLE;