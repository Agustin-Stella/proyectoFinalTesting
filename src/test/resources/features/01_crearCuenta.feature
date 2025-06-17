Feature: Validar la creacion de cuenta
  Scenario: Crear cuenta
    Given El usuario esta en la pagina de registro
    When Ingresa nombre e gmail y aprieta sign up
    Then Rellena todos los campos con su informacion
    And Click en create Acount y verifica si se creo correctamente

