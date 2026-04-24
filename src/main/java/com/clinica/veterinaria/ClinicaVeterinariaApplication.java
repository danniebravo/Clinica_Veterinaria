package com.clinica.veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicacion.
 * Al ejecutar este archivo, arranca el servidor web en el puerto 8080.
 *
 * Para correr el proyecto:
 *   1. Abrir una terminal en VS Code
 *   2. Ejecutar: mvn spring-boot:run
 *   3. Abrir el navegador en: http://localhost:8080
 */
@SpringBootApplication
public class ClinicaVeterinariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaVeterinariaApplication.class, args);
        System.out.println("\n=========================================");
        System.out.println("  CLINICA VETERINARIA MVC");
        System.out.println("  Servidor corriendo en:");
        System.out.println("  http://localhost:8080");
        System.out.println("=========================================\n");
    }
}
