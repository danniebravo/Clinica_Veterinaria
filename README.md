# 🐾 Clínica Veterinaria MVC

Proyecto didáctico en **Java + Spring Boot** que demuestra el patrón **Modelo–Vista–Controlador** con una clínica veterinaria.

---

## 📂 Estructura del proyecto

```
clinica-veterinaria-mvc/
│
├── pom.xml                                      ← Configuración de Maven
│
└── src/main/
    ├── java/com/clinica/veterinaria/
    │   ├── ClinicaVeterinariaApplication.java   ← Arranca la app
    │   │
    │   ├── model/
    │   │   └── Mascota.java                     ← 🐕 MODELO (guarda datos)
    │   │
    │   ├── controller/
    │   │   └── MascotaController.java           ← 🧠 CONTROLADOR (decide)
    │   │
    │   └── repository/
    │       └── MascotaRepository.java           ← Habla con la BD
    │
    └── resources/
        ├── application.properties               ← Configuración
        └── static/
            └── index.html                       ← 🖥️ VISTA (formulario)
```

---

## ⚙️ Requisitos

Necesitas tener instalado:

- **Java 17 o superior** → [descargar](https://adoptium.net/)
- **Maven** (o usar la extensión de VS Code que lo trae)
- **VS Code** con las extensiones:
  - Extension Pack for Java (Microsoft)
  - Spring Boot Extension Pack (VMware)

Para verificar que Java está instalado, en la terminal escribe:

```bash
java -version
```

---

## ▶️ Cómo ejecutar el proyecto en VS Code

1. **Abrir el proyecto en VS Code**
   - Archivo → Abrir carpeta → selecciona la carpeta `clinica-veterinaria-mvc`

2. **Esperar a que VS Code descargue las dependencias**
   - La primera vez tarda unos minutos. Lo verás en la barra inferior.

3. **Ejecutar la aplicación**

   **Opción A — Desde el editor:**
   - Abrir el archivo `ClinicaVeterinariaApplication.java`
   - Hacer clic en el botón ▶️ "Run" sobre el método `main`

   **Opción B — Desde la terminal:**
   ```bash
   mvn spring-boot:run
   ```

4. **Abrir el navegador en:**
   ```
   http://localhost:8080
   ```

   ¡Listo! Verás el formulario para registrar mascotas. 🎉

---

## 🔁 Cómo funciona el flujo MVC

Cuando registras a Rocky en el formulario, esto sucede:

```
  1                 2                 3
  │                 │                 │
  ▼                 ▼                 ▼
┌─────────┐   ┌──────────────┐   ┌─────────┐
│  VISTA  │──▶│ CONTROLADOR  │──▶│ MODELO  │
│ (HTML)  │   │ (Spring)     │   │ (BD H2) │
│ index   │◀──│  Mascota     │◀──│ Mascota │
│ .html   │   │  Controller  │   │ .java   │
└─────────┘   └──────────────┘   └─────────┘
      5                 4
```

1. **Vista** → El usuario llena el formulario con "Rocky, Perro, 3"
2. **Controlador** → Recibe los datos vía `POST /mascotas`
3. **Modelo** → La clase `Mascota` se guarda en la base de datos
4. **Controlador** → Responde con la mascota guardada (ya tiene ID)
5. **Vista** → Muestra "✓ Mascota Rocky registrada correctamente"

---

## 🧪 Probar la API directamente

Con la app corriendo, puedes probar los endpoints del Controlador:

### Registrar una mascota
```bash
curl -X POST http://localhost:8080/mascotas \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Rocky","tipo":"Perro","edad":3}'
```

### Listar todas las mascotas
```bash
curl http://localhost:8080/mascotas
```

### Buscar por ID
```bash
curl http://localhost:8080/mascotas/1
```

### Eliminar una mascota
```bash
curl -X DELETE http://localhost:8080/mascotas/1
```

---

## 🗄️ Ver la base de datos

Con la app corriendo, abre:

```
http://localhost:8080/h2-console
```

- **JDBC URL:** `jdbc:h2:mem:clinicadb`
- **User:** `sa`
- **Password:** (dejar vacío)

Clic en "Connect" y luego ejecuta:
```sql
SELECT * FROM MASCOTA;
```

---

## 🎓 Puntos clave para exponer en clase

✅ El **Modelo** (`Mascota.java`) solo describe los datos. No sabe de pantallas.

✅ La **Vista** (`index.html`) solo muestra y recibe información del usuario. No guarda nada.

✅ El **Controlador** (`MascotaController.java`) es el único que conecta la Vista con el Modelo.

✅ Si borras el Controlador, la Vista y el Modelo no pueden comunicarse → **el sistema no funciona**.

---

**Actividad:** Clínica Veterinaria 🐾
