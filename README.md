
# Book API REST - Spring Boot

## Descripción
Creación de un API REST con Spring Boot y Java, en donde se realiza una conexión a una base de datos relacional de Postgresql y se utiliza JPA como ORM para la debida conexión e interacción con la base de datos, por otra parte cuenta con varias entidades que se relacione con la entidad principal (Book) con los siguientes tipos de relaciones: Uno a Muchos, Muchos a Muchos y Uno a Uno, además de ello se raliza un manejo de excepciones para generar respuestas de error con mensajes más específicos, también se realiza una carga de archivos (imágenes) al storage de cloudinary.

## Pasos para le ejecución de la aplicación
- Ejecutar el comando ```docker compose up -d``` para levantar la base de datos con Docker, si desea cambie la configuración en el archivo ```docker-compose.yml```.
- Si cambia la configuración del archivo ```docker-compose.ym```, recurde tambien cambiar la configuración de la conexión de la base de datos en ```src/main/resources/application.properties```.
- En el archivo ```application.properties``` agregar las credenciales para configurar cloudinary.
- Levantar la aplicación desde el Dashboard de Spring Boot.

## Tecnologías Utilizadas
- <div style="display:flex;aling-items:center;gap:5px;"><a href="https://spring.io/projects/spring-boot">Spring Boot</a> <img src="https://res.cloudinary.com/dxn0tqsnw/image/upload/c_crop,ar_1:1/v1735852977/brief/spring-boot-ok_cjksvk.png" width="20px" height="auto" /> </div>
- <div style="display:flex;aling-items:center;gap:5px;"><a href="https://www.postgresql.org/">Postgresql</a> <img src="https://res.cloudinary.com/dxn0tqsnw/image/upload/v1735852977/brief/Postgresql_elephant.svg_yvfabq.png" width="20px" height="auto" /> </div>
- <div style="display:flex;aling-items:center;gap:5px;"><a href="https://www.docker.com/">Docker</a> <img src="https://res.cloudinary.com/dxn0tqsnw/image/upload/v1724818746/brief/docker_xjvooq.png" width="20px" height="auto" /> </div>
- <div style="display:flex;aling-items:center;gap:5px;"><a href="https://cloudinary.com/">Cloudinary</a> <img src="https://res.cloudinary.com/dxn0tqsnw/image/upload/v1737401878/brief/channels4_profile_c7dico.jpg" width="20px" height="auto" /> </div>
