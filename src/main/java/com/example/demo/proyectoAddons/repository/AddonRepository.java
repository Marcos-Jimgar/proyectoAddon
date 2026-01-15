package com.example.demo.proyectoAddons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.proyectoAddons.model.Addon;

public interface AddonRepository extends JpaRepository<Addon, Long> {

    // INSERT INTO PERSONALIZADO
    @Modifying
    @Query(value = "INSERT INTO creador_addon (creador_id, addon_id) VALUES (:idCreador, :idAddon)", nativeQuery = true)
    int insertarCreadorAddon(
            @Param("idCreador") Long idCreador,
            @Param("idAddon") Long idAddon);
            
@Query(value = "SELECT creador_id FROM creador_addon WHERE addon_id = :idAddon", nativeQuery = true)
List<Long> getRelacionesPorAddon(@Param("idAddon") Long idAddon);


}

// sudo -u postgres psql
// \c mydb
// SELECT * FROM TABLE;