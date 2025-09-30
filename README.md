# Microservicios para gestión de presupuestos

Microservicios desarrollados con Spring Boot, Spring Data JPA y Spring Cloud, que permiten administrar presupuestos de proyectos. Incluye integración con MySQL y PostgreSQL, un Config Server, Eureka Server para descubrimiento de servicios, y un API Gateway para el enrutamiento de las rutas.

## Tecnologías y herramientas utilizadas
- Java 17
- Spring Boot (Web, Data JPA, Cloud)
- Hibernate
- MySQL
- PostgresSQL
- Maven
- Postman

## Funcionalidades principales
- Solicitudes CRUD para los microservicios ppto_contrata y ppto_origen.
- Comunicación de microservicios mediante WebClient.
- Eureka Server para el registro de microservicios. 
- Config Server para centralizar la configuración de los microservicios.
- Api Gateway para el enrutamiento de las solicitudes.
- Patrón Circuit Breaker implementado para mitigar fallas en la comunicación entre microservicios, 
  evitando sobrecargar servicios que están temporalmente inactivos o con errores.

## Arquitectura

```mermaid
flowchart TD
    user([👤 Usuario]) --> gateway[🌐 API Gateway]

    subgraph Microservicios
        contrata[📦 ppto_contrata]
        origen[📦 ppto_origen]
        eureka[🔎 Eureka Server]
        config[⚙️ Config Server]
    end

    subgraph Bases de Datos
        mysql[(🗄️ MySQL DB)]
        postgres[(🗄️ PostgreSQL DB)]
    end

    gateway --> contrata
    gateway --> origen

    contrata --> mysql
    origen --> postgres
    contrata --> config
    origen --> config
    gateway -->config
```

## Ejecución del proyecto

### 1. Clonar el repositorio
```bash
git clone https://github.com/wilfredohuarotog/Microservicios-Gestion-de-presupuestos.git
```
### 2. Ingresar al directorio
```
cd Microservicios-Gestion-de-presupuestos
```
### 4. Ejecutar para cada microservicio:

- Config-server:
```
mvn spring-boot:run -pl config-server
```
- Eureka-server:
```
mvn spring-boot:run -pl eureka-server
```
- Api-gateway:
```
mvn spring-boot:run -pl gateway
```
- Pptp-origen:
```
mvn spring-boot:run -pl ppto-origen
```
- Pptp-contrata:
```
mvn spring-boot:run -pl ppto-contrata
```

## Uso
- Tanto para el microservicio ppto-origen y ppto-contrata se puede hacer la consultas CRUD.
### Endpoint especial:
- Obtener lista de pptos de la contrata que pertenecen a un ppto (origen) identificado por su ID: `GET http://localhost:8080/api/v1/p-contrata/p-origen/{id}`

### Documentación
`Documentación de endpoints, accedes:` https://documenter.getpostman.com/view/46041910/2sB3QFRCPr
