Feature: Validar el carrito
  Scenario: Utilizar el carrito
    Given El usuario esta en la pagina de productos
    When Añadimos un producto al carrito
    And Click en continue
    Then Abrimos el carro y el producto debe estar en el
    And Cerrar pagina