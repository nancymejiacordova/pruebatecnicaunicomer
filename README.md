# Prueba Tecnica Unicomer
Prueba Tecnica Integracion Unicomer
## Requisitos

- Consumir una API externa de feriados.
- Filtrar los feriados por tipo y rango de fechas.
- Respuestas en JSON y XML.
- Contenerización con Docker.
- debera estar configurado el GraalVM para java21

## Tecnologías

- **Spring Boot 3.3** (con soporte de Spring Native)
- **Java 21**
- **Docker**
- **Maven**

# Proyecto Docker

Este proyecto utiliza Docker para la contenerización y ejecución de la aplicación.

## Requisitos

- [Docker](https://www.docker.com/get-started) instalado en tu máquina.
- (Opcional) [Docker Compose](https://docs.docker.com/compose/install/) si se usa `docker-compose.yml`.

## otros


### 1. Acceder a la aplicación

Abre en tu navegador: [http://localhost:8080](http://localhost:8080)

## 2. Uso con Docker Compose (Opcional)

```sh
docker-compose up -d
```

## 3. Ver contenedores activos

```sh
docker ps
```

## 4. Ver imágenes disponibles

```sh
docker images
```

## Notas

- Asegúrate de que el puerto 8080 esté libre o cambia el mapeo en `-p 8080:8080`.
- Modifica el `Dockerfile` si necesitas agregar dependencias adicionales.
- Usa volúmenes (`-v`) si deseas persistencia de datos.



