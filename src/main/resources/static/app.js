const API = '/mascotas';

// Escuchar cuando el usuario envía el formulario
document.getElementById('formMascota').addEventListener('submit', async (e) => {
    e.preventDefault();

    // 1. La VISTA toma los datos del formulario
    const mascota = {
        nombre: document.getElementById('nombre').value,
        tipo:   document.getElementById('tipo').value,
        edad:   parseInt(document.getElementById('edad').value)
    };

    console.log('VISTA: enviando datos al CONTROLADOR...', mascota);

    try {
        // 2. La VISTA llama al CONTROLADOR para que guarde la mascota
        const respuesta = await fetch(API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(mascota)
        });

        if (!respuesta.ok) throw new Error('Error al guardar');

        const guardada = await respuesta.json();
        console.log('CONTROLADOR respondió:', guardada);

        // 3. La VISTA muestra el resultado al usuario
        mostrarMensaje(`✓ Mascota ${guardada.nombre} registrada correctamente (ID: ${guardada.id})`, 'exito');
        document.getElementById('formMascota').reset();

        // Recargar la lista
        cargarMascotas();

    } catch (err) {
        mostrarMensaje('✗ Error al guardar la mascota', 'error');
        console.error(err);
    }
});

// Cargar las mascotas desde el Controlador y mostrarlas
async function cargarMascotas() {
    try {
        const respuesta = await fetch(API);
        const mascotas = await respuesta.json();

        const contenedor = document.getElementById('tablaContenedor');

        if (mascotas.length === 0) {
            contenedor.innerHTML = '<p class="vacio">Aún no hay mascotas registradas. ¡Registra la primera arriba! 🐶</p>';
            return;
        }

        let html = `
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th>Edad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
        `;

        mascotas.forEach(m => {
            html += `
                <tr>
                    <td>${m.id}</td>
                    <td><strong>${m.nombre}</strong></td>
                    <td>${m.tipo}</td>
                    <td>${m.edad} años</td>
                    <td><button class="btn-eliminar" onclick="eliminarMascota(${m.id})">Eliminar</button></td>
                </tr>
            `;
        });

        html += '</tbody></table>';
        contenedor.innerHTML = html;

    } catch (err) {
        console.error('Error al cargar mascotas:', err);
    }
}

// Eliminar una mascota
async function eliminarMascota(id) {
    if (!confirm('¿Seguro que deseas eliminar esta mascota?')) return;

    try {
        await fetch(`${API}/${id}`, { method: 'DELETE' });
        mostrarMensaje('Mascota eliminada', 'exito');
        cargarMascotas();
    } catch (err) {
        mostrarMensaje('Error al eliminar', 'error');
    }
}

function mostrarMensaje(texto, tipo) {
    const msg = document.getElementById('mensaje');
    msg.textContent = texto;
    msg.className = tipo;
    setTimeout(() => { msg.className = ''; msg.style.display = 'none'; }, 4000);
}

// Al cargar la página, mostrar las mascotas que ya existen
cargarMascotas();
