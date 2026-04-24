package com.clinica.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * MODELO (Model)
 *
 * Representa una Mascota en la clinica veterinaria.
 * Esta clase solo guarda los datos. No sabe nada de pantallas ni de botones.
 *
 * La anotacion @Entity le dice a Spring que esta clase se guarda en la base de datos.
 */
@Entity
public class Mascota {

    // El ID se genera automaticamente cada vez que se guarda una mascota
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private int edad;

    // Constructor vacio (lo necesita Spring/JPA)
    public Mascota() {
    }

    // Constructor con todos los datos
    public Mascota(String nombre, String tipo, int edad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }

    // ===== Getters y Setters =====
    // Son metodos para leer (get) y cambiar (set) los datos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
