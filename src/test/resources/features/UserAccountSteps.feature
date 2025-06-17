Feature: Validar el Login y eliminación de cuenta

  Scenario: El usuario inicia sesión y elimina la cuenta
    Given El usuario esta en la pagina de login
    When Rellena los campos gmail y password
    And Click en Login y verifica si se logueo correctamente
    Then Click en eliminar cuenta
    And Verifica si se elimino correctamente