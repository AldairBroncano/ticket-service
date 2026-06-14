# Ticket Service

Microservicio desarrollado con arquitectura hexagonal (Ports & Adapters).

## Tecnologías
- Java 21
- Spring Boot 4.1.x
- Maven

## Arquitectura
El proyecto sigue una arquitectura hexagonal dividida en 3 capas:

- **Domain:** modelos y puertos (interfaces). No depende de ningún framework.
- **Application:** casos de uso que orquestan el flujo.
- **Infrastructure:** adaptadores — Google Drive, PDFs, Excel, REST API.
