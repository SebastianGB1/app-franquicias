# APP Franquicias

Este documento proporciona las instrucciones para construir y ejecutar la aplicación dentro de un contenedor Docker.

Los endpoints disponibles estan en la coleccion de postman del proyecto

# Instrucciones de instalacion

## Prerrequisitos

- Tener instalado [Docker](https://www.docker.com/get-started)

### Clonar el repositorio

```bash
git clone https://github.com/SebastianGB1/app-franquicias.git
```

### Entrar a la carpeta del proyecto

````bash
cd app-franquicias/app
````

### Construcción de la Imagen Docker

Ejecuta el siguiente comando para construir la imagen de Docker:

```sh
docker build -t app-franquicias .
```

Esto creará una imagen con el nombre `app-franquicias`.

## Ejecución del Contenedor

Para ejecutar el contenedor en modo **detached** (segundo plano) y exponer el puerto de la aplicación, usa el siguiente
comando:

```sh
docker run -d --name app-franquicias-container \
    -p 8085:8085 \
    -e DB_NAME=franquicias \
    -e DB_HOST=localhost \
    -e DB_PORT=3306 \
    -e DB_USER=root \
    -e DB_PASSWORD=secret \
    app-franquicias
```

Tambien se puede usar el archivo env para correr el contenedor (se debe modificar los valores en el archivo antes de
ejecutar el comando)

````bash
docker run -d --file-env env --name app-franquicias-container -p 8085:8085 app-franquicias
````

## Verificación

Para comprobar que el contenedor está corriendo:

```sh
docker ps
```

Para ver los logs en tiempo real:

```sh
docker logs -f app-franquicias-container
```
