# Microservices Demo

Este proyecto contiene dos microservicios: Orchestrator y Domain. El Orchestrator recibe solicitudes, las valida y maneja excepciones, mientras que el Domain guarda la información en una base de datos H2. Ambos microservicios están desarrollados en Java 17 utilizando Spring Boot.

## Prerrequisitos

- Java 17
- IntelliJ IDEA
- Git

## Instalación

1. Clona este repositorio:

   ```sh
   git clone https://github.com/tu-usuario/microservices-demo.git
   cd microservices-demo
2. Abre IntelliJ IDEA y selecciona "Open" para abrir el proyecto microservices-demo.

3. IntelliJ IDEA detectará automáticamente los módulos Maven. Si no lo hace, asegúrate de que Maven esté configurado correctamente en IntelliJ IDEA:
    Ve a File > Project Structure > Project y asegúrate de que el SDK del proyecto esté configurado en Java 17.
    Ve a File > Settings > Build, Execution, Deployment > Build Tools > Maven y asegúrate de que la configuración de Maven esté correcta.
   
5. Espera a que IntelliJ IDEA descargue las dependencias de Maven y configure el proyecto.

## Ejecución

Ejecutar Orchestrator
En IntelliJ IDEA, navega al módulo orchestrator en el panel de proyecto.

Abre la clase OrchestratorApplication ubicada en src/main/java/com/example/orchestrator.

Haz clic derecho en la clase OrchestratorApplication y selecciona Run 'OrchestratorApplication'.

Esto iniciará el Orchestrator en http://localhost:8080.

Ejecutar Domain
Abre una nueva ventana de IntelliJ IDEA o un nuevo proyecto en la misma ventana y navega al módulo domain en el panel de proyecto.

Abre la clase DomainApplication ubicada en src/main/java/com/example/domain.

Haz clic derecho en la clase DomainApplication y selecciona Run 'DomainApplication'.

Esto iniciará el Domain en http://localhost:8081.

## Uso

### Endpoints del Orchestrator
1. POST /orchestrator/process

Procesa y valida la solicitud antes de enviarla al Domain.
Ejemplo de solicitud:

    {
      "nombre": "Producto",
      "precio": 100
    }
    
Respuestas posibles:
200 OK: Solicitud procesada correctamente.
400 Bad Request: Datos inválidos.
500 Internal Server Error: Error procesando la solicitud.

2. GET /orchestrator/entities

Recupera todas las entidades almacenadas en el Domain.
Respuestas posibles:

200 OK: Lista de entidades.

500 Internal Server Error: Error recuperando las entidades.

### Endpoints del Domain
1. POST /domain/save

Guarda una nueva entidad en la base de datos.
Ejemplo de solicitud:

    {
      "nombre": "Producto",
      "precio": 100
    }
Respuestas posibles:
200 OK: Entidad guardada correctamente.

400 Bad Request: Datos inválidos.

500 Internal Server Error: Error guardando la entidad.

2. GET /domain/entities

Recupera todas las entidades almacenadas.
Respuestas posibles:
200 OK: Lista de entidades.

## Pruebas
Para probar la aplicación, puedes utilizar Postman o cualquier otra herramienta para realizar solicitudes HTTP. Asegúrate de que ambos microservicios estén en ejecución antes de realizar las pruebas.

## Contribuciones
Si deseas contribuir a este proyecto, por favor, realiza un fork del repositorio y envía un pull request con tus cambios.
