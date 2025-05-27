Feature: Validar Login
  Scenario: Logearse
    Given El usuario esta en la pagina de login
    When Rellena los campos gmail y contraseña
    And Click en Login
    And Cierre de la pagina