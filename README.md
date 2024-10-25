<h1 align="center">Daily Activities API</h1>
<p></p>

## Índice
- [Base de datos](#BBDD)
- [Documentación API](#API)

<h2 name="BBDD">Base de datos</h2>
<p>Para la creación de la base de datos se decidió utilizar la base de datos ya creada, dado que cumple con los requerimientos válidos para el proyecto.</p>

<h3>Modelo UML</h3>
<p>A partir de la base de datos ofrecida al principio del proyecto sin realizar modificaciones.</p>
<p align="center"><img src="./media/ERM.png" width=90%/></p>

<h3>Modelo Físico</h3>
<p>Este modelo fue tomado directamente de lo proveído para empezar con una base de datos ya propuesta.</p>

```sql
-- Tabla de Usuarios
CREATE TABLE usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    contrasena_hash TEXT NOT NULL,
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT UC_nombre_usuario UNIQUE (nombre_usuario),
    CONSTRAINT UC_email UNIQUE (email)
);

-- Tabla de Actividades
CREATE TABLE activdades (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NULL,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT NULL,
    estado ENUM('pendiente', 'en proceso', 'completada') NOT NULL,
    prioridad ENUM('alta', 'media', 'baja') NOT NULL DEFAULT 'media',
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_de_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuarios_actividades FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla de Recordatorios
CREATE TABLE recordatorios (
    id INT NOT NULL AUTO_INCREMENT,
    actividades_fk INT NULL,
    fecha_de_recordatorio DATETIME NOT NULL,
    mensaje TEXT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_actividades_recordatorios FOREIGN KEY (actividades_fk) REFERENCES activdades (id)
);

-- Tabla de Objetivos
CREATE TABLE objetivos (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT NULL,
    fecha_de_vencimiento DATETIME NULL,
    estado ENUM('activo', 'pendiente', 'suspendido') NOT NULL,
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuarios_objetivos FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla de Hitos para los Objetivos
CREATE TABLE hitos (
    id INT NOT NULL AUTO_INCREMENT,
    objetivo_fk INT NOT NULL,
    descripcion TEXT NOT NULL,
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completado BOOLEAN DEFAULT FALSE,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_objetivo_hitos FOREIGN KEY (objetivo_fk) REFERENCES objetivos (id)
);

-- Tabla de Estadísticas
CREATE TABLE estadisticas (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NULL,
    fecha_de_la_estadística TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    actividades_completadas INT NOT NULL,
    objetivos_completados INT NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuarios_estadisticas FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla de Categorías
CREATE TABLE categorias (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id)
);

-- Tabla de Etiquetas
CREATE TABLE etiquetas (
    id INT NOT NULL AUTO_INCREMENT,
    actividades_fk INT NULL,
    nombre VARCHAR(100) NOT NULL,
    categoria_fk INT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_actividades_etiquetas FOREIGN KEY (actividades_fk) REFERENCES activdades (id),
    CONSTRAINT FK_categorias_etiquetas FOREIGN KEY (categoria_fk) REFERENCES categorias (id)
);

-- Tabla para la Colaboración entre Usuarios en Actividades
CREATE TABLE colaboraciones (
    id INT NOT NULL AUTO_INCREMENT,
    actividad_fk INT NOT NULL,
    usuario_fk INT NOT NULL,
    rol ENUM('creador', 'colaborador') NOT NULL DEFAULT 'colaborador',
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_actividad_colaboraciones FOREIGN KEY (actividad_fk) REFERENCES activdades (id),
    CONSTRAINT FK_usuario_colaboraciones FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla para Reportes de Rendimiento
CREATE TABLE reportes (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NOT NULL,
    tipo_reporte ENUM('diario', 'semanal', 'mensual') NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME NOT NULL,
    actividades_completadas INT DEFAULT 0,
    objetivos_completados INT DEFAULT 0,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuario_reportes FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);
```
<h2 name="API">Documentación API</h2>
<p></p>

<h3>Swagger</h3>
<p></p>
<p>Link: https://app.swaggerhub.com/apis-docs/DANIDIDIFB/DailyActivities/1.0.0</p>

<h3>End Points</h3>
<table align="center">
  <tr>
    <td width=20><h3 align="center">Ruta<h3></td>
    <td width=10><h3 align="center">Método<h3></td>
    <td width=70><h3 align="center">Descripción<h3></td>
  </tr>
  <tr>
    <td width=20>/usuarios/iniciarSesion</td>
    <td width=10><i>POST</i></td>
    <td width=70>Obtiene la información del usuario excluyendo <b>contrasena_hash</b> y el campo <b>fecha_de_creacion</b>, devuelve la fecha y hora actual del inicio de sesión. Además, se cambia el nombre del campo a <b>fecha_y_hora_de_inicio_de_sesion</b>.</td>
  </tr>
  <tr>
    <td width=20>/usuarios/validarSesion</td>
    <td width=10><i>POST</i></td>
    <td width=70>Descifrar la sesión proporcionada en el header: <br><code>Authorization: Bearer [token]</code></br> y retornar la información que incluye.</td>
  </tr>
</table>
