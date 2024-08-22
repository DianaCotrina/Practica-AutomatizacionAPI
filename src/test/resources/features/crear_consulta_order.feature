Feature: Creación y consulta de pedidos de la tienda PetStore

  @crearOrder
  Scenario: Creación de order

    When creo la order con petId 5 y quantity 40
    Then el código de respuesta es 200
    And el status como "placed"
    And complete es true

  @consultaOrder
  Scenario: Consulta de order
    Given que tengo la url del servicio "https://petstore.swagger.io/v2/store/order"
    When hago la consulta de la order por orderId
    Then el código de respuesta es 200
    And el status como "placed"
    And complete es true


  @creacionOrders
  Scenario Outline: Creacion de varias order

    When creo la order con petId <petId> y quantity <quantity>
    Then el código de respuesta es 200
    And el status como "placed"
    And complete es true
    Examples:
    |petId  |quantity   |
    |    2  |   30      |
    |    3  |   20      |