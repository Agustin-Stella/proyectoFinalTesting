Feature: Validar el carrito
  Scenario: Utilizar el carrito
    Given El usuario esta en la pagina de productos
    When Añadimos un producto al carrito
    And Click en continue
    And Cerrar pagina