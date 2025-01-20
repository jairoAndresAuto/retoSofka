#language: es
## jairo.garcia@sofka.com.co
Característica: Gestionar booking
  Yo como QA deseo realizar el proceso de automatización de pruebas
  Para el microservicio delegados booking
  Con el fin de presentar un stack de pruebas referenciado a dicho microservicio

  Escenario: Crear booking
    Dado Procede a realizar el llamado del servicio de booking
    Cuando Se procede a crear el booking
    Entonces Podemos observar el codigo 200

  Esquema del escenario: Crear booking validar falta de datos
    Dado Procede a realizar el llamado del servicio de booking
    Cuando Se procede a crear el booking con los siguientes datos
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Entonces Podemos observar el codigo "<codigo>"

    Ejemplos:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | codigo |
      |           | garzon   | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 200    |
      | Andres    |          | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 200    |
      | Andres    | garzon   |            | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 400    |
      | Andres    | garzon   | 111        |             | 2018-01-01 | 2019-01-01 | Breakfast       | 400    |
      | Andres    | garzon   | 111        | true        |            | 2019-01-01 | Breakfast       | 200    |
      | Andres    | garzon   | 111        | true        | 2018-01-01 |            | Breakfast       | 200    |
      | Andres    | garzon   | 111        | true        | 2018-01-01 | 2019-01-01 |                 | 200    |

  Esquema del escenario: Crear booking validar tipos de datos
    Dado Procede a realizar el llamado del servicio de booking
    Cuando Se procede a crear el booking con los siguientes datos
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Entonces Podemos observar el codigo "<codigo>"

    Ejemplos:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | codigo |
      | $$        | garzon   | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 200    |
      | Andres    | $$       | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 200    |
      | Andres    | garzon   | $$         | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 400    |
      | Andres    | garzon   | 111        | $$          | 2018-01-01 | 2019-01-01 | Breakfast       | 400    |
      | Andres    | garzon   | 111        | true        | $$         | 2019-01-01 | Breakfast       | 200    |
      | Andres    | garzon   | 111        | true        | 2018-01-01 | $$         | Breakfast       | 200    |
      | Andres    | garzon   | 111        | true        | 2018-01-01 | 2019-01-01 | $$              | 200    |

  Escenario: obtener booking
    Dado Procede a realizar el llamado del servicio de booking
    Cuando Se procede a obtener el booking
    Entonces Podemos observar el codigo 200

  Escenario: obtener booking no creado
    Dado Procede a realizar el llamado del servicio de booking
    Cuando Se procede a obtener el booking con 50000
    Entonces Podemos observar el codigo 404

  Escenario: actualizar booking
    Dado que procede a realizar la creacion del token
    Cuando Procede a realizar el llamado del servicio de booking
    Y Se procede a actualizar el booking
    Entonces Podemos observar el codigo 200

  Escenario: actualizar booking con token invalido
    Dado Procede a realizar el llamado del servicio de booking
    Cuando Se procede a actualizar el booking con token invalido
    Entonces Podemos observar el codigo 403