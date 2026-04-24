package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CONTROLADOR (Controller)
 *
 * Este es el "recepcionista" de la clinica.
 * Recibe las peticiones que llegan desde la Vista (el formulario),
 * decide que hacer, y habla con el Modelo para guardar o consultar datos.
 *
 * @RestController le dice a Spring que esta clase recibe peticiones web.
 * @RequestMapping("/mascotas") hace que todas las URLs empiecen con /mascotas
 */
@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    // Spring nos da automaticamente el repositorio para hablar con el Modelo
    @Autowired
    private MascotaRepository repo;

    /**
     * Registrar una mascota nueva.
     *
     * Cuando la Vista envia los datos del formulario (Rocky, Perro, 3),
     * este metodo los recibe y le pide al Modelo que los guarde.
     *
     * URL: POST http://localhost:8080/mascotas
     */
    @PostMapping
    public Mascota guardar(@RequestBody Mascota m) {
        System.out.println(">> Controlador: recibi la mascota " + m.getNombre());
        System.out.println(">> Controlador: enviando al Modelo para guardar...");
        Mascota guardada = repo.save(m);
        System.out.println(">> Modelo: mascota guardada con ID = " + guardada.getId());
        return guardada;
    }

    /**
     * Listar todas las mascotas registradas.
     *
     * URL: GET http://localhost:8080/mascotas
     */
    @GetMapping
    public List<Mascota> listar() {
        return repo.findAll();
    }

    /**
     * Buscar una mascota por su ID.
     *
     * URL: GET http://localhost:8080/mascotas/1
     */
    @GetMapping("/{id}")
    public Mascota buscarPorId(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Eliminar una mascota por su ID.
     *
     * URL: DELETE http://localhost:8080/mascotas/1
     */
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "Mascota eliminada correctamente";
    }
}
