# PRICE API REST
API REST que expone un servicio para calcular el precio final PVP de un producto para una tarifa, desarrollado con `Spring Boot`, `Spring Data`, `JPA` y `H2`. 
Se implementan como buenas prácticas la optimicación de queries, documentación de la api, pruebas, patrones, separación de responsabilidades, desacoplamiento entre capas, interfaces, clases genéricas, entre otros. 
Para escribir un código más simple y legible se aplican anotaciones, implementan validadores y emplea `Lombok`.
Se aplican principios de una arquitectura hexagonal, centrada en `Domain Driver Design`.
Para gestionar migraciones `flyway`.
La API fue documentada con `Open API Swagger` y testeada con suite de pruebas en `Postman` y desarrollaron pruebas automatizadas con `JUnit`.


# REQUERIMIENTOS Y SET UP
- Java 18
- Maven. El `pom` contiene todas las dependencias y versiones:
  
    `mvn clean install`
- Puerto 8000 disponible. Sino modificarlo usando la variable de entorno `ENV_PORT` o directamente en `application.yml`:
  
      server:
         port: ${ENV_PORT:8000}
  
- Ejecutar el proyecto:

    `mvn spring-boot:run`

### DOCUMENTACION SWAGGER:

Disponible una vez se encuentre el proyecto en ejecución por: http://localhost:8000/api/v1/swagger-ui.html
![swagger_view.png](readme%2Fswagger_view.png)

La api first se encuentra en el repo en: `docs/api_first_v1.0.yml`

Las descripciones de la documentación se externalizaron en arichivos con diferentes lenguajes propiamente para ello (para dejar el código limpio). Por defecto cargo la documentación en inglés, para cambiar a español modifique por `_es`:

    language: i18n/swagger_messages_es.properties # use "i18n/swagger_messages_es" for spanish language

![swagger_view_es.png](readme%2Fswagger_view_es.png)

### COLLECCION POSTMAN
Se ha añadido la colección de Postman realizada al repo. En: `docs/postman_collection.json`.

### BASE DE DATOS h2
Disponible una vez se encuentre el proyecto en ejecución por: http://localhost:8000/api/v1/h2-ui/. Este path se puede modificar en:
    
    h2:
      console:
        enabled: true
        path: /h2-ui

Las credenciales se pueden modificar en:

    spring:
      datasource:
        username: sa
        password:

Se puede activar la vista de sql mediante:

      jpa:
         show-sql: true

### MIGRACIONES:

Se definieron migraciones (`/resources/db/migration`) con flyway para:
- definir la estructura inicial de la DB (DDL)
- tener datos de pruebas para pruebas de integración

Se han implementado dos repositorios jpa:
- `PriceJpaRepository`: se realiza una Query directamente para obtener el pvp con los requerimientos indicados, usando una proyección para no recuperar todo el objeto sino solo los campos necesarios y con limite 1 para tomar el Top que es el de mayor prioridad (más óptimo)
- `PriceJpaSpecificationExecutor`: se realiza la misma operación pero usando especificaciones, que es una alternativa que no ata a un gestor pero menos óptima porque devuelve un listado para luego tomar el 1ro, no aplico el Page para obtener un único resultado porque eso siempre ejecuta count( * ) antes de select, lo que es subóptimo en la mayoría de los casos en bases de datos grandes

Se evaluaron ambos métodos y el más óptimo es QUERY, a continuación las queries que genera cada caso:

SPECIFICATION: `select pe1_0.id,pe1_0.brand_id,pe1_0.currency,pe1_0.end_date,pe1_0.price,pe1_0.priority,pe1_0.product_id,pe1_0.start_date from price pe1_0 where pe1_0.product_id=? and pe1_0.brand_id=? and pe1_0.start_date<=? and pe1_0.end_date>=? and 1=1 order by pe1_0.priority desc`

QUERY: `select pe1_0.product_id,pe1_0.brand_id,pe1_0.id,pe1_0.start_date,pe1_0.end_date,pe1_0.price from price pe1_0 where pe1_0.product_id=? and pe1_0.brand_id=? and ? between pe1_0.start_date and pe1_0.end_date order by pe1_0.priority desc fetch first 1 rows only`

`QUERY` es más óptimo porque recupera un solo valor que además es una proyección, su explain es menor

Los métodos se pueden configurar en:
  
    filer:
       method:
          apply: QUERY # options: SPECIFICATION or QUERY

### PRUEBAS
Se realizaron pruebas con Postman, pruebas unitarias con Junit y mockito y pruebas de integración para validar los casos de prueba indicados.

- Suite de pruebas con Postman:
  ![suite-postman.png](readme%2Fsuite-postman.png)

- Pruebas unitarias y de integración. La siguiente suite de pruebas contiene la comprobación de las 5 casuísticas descritas en la orden del ejercicio

  Run `JpaPriceRepositoryItTest`

  ![suite-test.png](readme%2Fsuite-test.png)

  - Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA) -> PVP resultante: `Precio-35.50 Id-1`
  - Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA) -> PVP resultante: `Precio-25.45 Id-2`
  - Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA) -> PVP resultante: `Precio-35.50 Id-1`
  - Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA) -> PVP resultante: `Precio-30.50 Id-3`
  - Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA) -> PVP resultante: `Precio-38.95 Id-4`

 Ejecutar todos los test:
    `mvn test`