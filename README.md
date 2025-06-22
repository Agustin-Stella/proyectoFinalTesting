Este proyecto es un framework de automatización de pruebas desarrollado en **Java**, utilizando **Cucumber** como herramienta BDD (Behavior Driven Development). Está diseñado para validar funcionalidades clave en la pagina : https://automationexercise.com/.

## 🚀 Tecnologías utilizadas

- Java
- Cucumber
- Selenium WebDriver
- Maven 
- IDE: IntelliJ IDEA 

## 📂 Estructura del proyecto

El proyecto está organizado en diferentes clases y paquetes para manejar cada conjunto de pruebas por funcionalidad:

- `TestRunner.java` - Clase principal que ejecuta los escenarios de Cucumber.
- `Hooks.java` - Maneja la configuración y limpieza del entorno de pruebas (antes y después de cada escenario).
- `stepBuscarProducto.java` - Define los pasos para la funcionalidad de búsqueda de productos.
- `stepCarrito.java` - Pruebas relacionadas con el carrito de compras.
- `stepCrearCuenta.java` - Validaciones del proceso de creación de cuenta de usuario.
- `StepHome.java` - Pasos relacionados con la página de inicio y navegación general.
- `UserAccountSteps.java` - Acciones y validaciones de cuenta de usuario (inicio de sesión, perfil, etc.).

## ✅ Funcionalidades cubiertas

- 🔍 Búsqueda de productos
- 🛒 Agregado de productos al carrito
- 👤 Crear y eliminar cuenta
- 🔐 Gestión de cuenta de usuario
- 🏠 Validación en la página principal

##Asegurar
-Todos los steps tienen las validaciones correspondientes para verificar el test.
