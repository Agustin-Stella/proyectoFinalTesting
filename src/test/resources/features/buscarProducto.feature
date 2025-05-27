Feature: Validar la busqueda de productos
  Scenario: Buscar producto
    Given El usuario se posiciona en la pagina de productos
    When Ingresa el nombre del producto en la barra de busqueda
    Then Hace click en la lupa
    And Cerrar pagina web