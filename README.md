# inteligencia-artificial
Repo para el proyecto de inteligencia artificial - TSP
- Spring boot
- Java 8
- Jenetics.io

Para iniciar la aplicacion, parados en el root del proyecto realizar una de las siguientes:
gradle bootRun
mvn spring-boot:run

Tambien es posible buildear la aplicacion ejecutando
gradle build

Este último comando deja crea en build/libs el jar de la version, y luego puede ejecutarse la aplicacion con el siguiente comando:
java -jar [nombre del jar]

Por defecto, levanta en el puerto 8070.

La aplicación expone dos recursos a consumir, 
GET /ciudad -> ciudades permitidas
POST /tsp -> calcula las distancias de las ciudades. En el Body del post enviar un array con las ciudades. Por ejemplo:
[
    "BUENOS_AIRES",
    "RIO_DE_JANEIRO",
    "LA_PAZ",
    "SANTIAGO",
    "BOGOTA",
    "SIDNEY",
    "MONTEVIDEO",
    "JOHANNESBURG",
    "MOSCU"
]
