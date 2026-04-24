package com.clinica.veterinaria.repository;

import com.clinica.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de Mascotas.
 *
 * Spring se encarga solo de crear los metodos para guardar (save),
 * buscar (findAll, findById) y eliminar (deleteById) mascotas.
 *
 * Nosotros no tenemos que escribir SQL. Spring lo hace por nosotros.
 */
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
