Feature: Validar el home
  Scenario: verificar url
    Given El usuario abre la pagina principal
    Then La url debe ser "https://automationexercise.com"
    And El usuario cierra la pagina  