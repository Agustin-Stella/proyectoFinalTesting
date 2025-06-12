# Proyecto de Automatización - Selenium y Cucumber

## 📌 Descripción
Este proyecto implementa pruebas automatizadas para la página [Automation Exercise](https://automationexercise.com/) utilizando Java, Selenium WebDriver y Cucumber. Las pruebas verifican el registro de usuarios, inicio de sesión, búsqueda de productos y gestión del carrito de compras.

## 🚀 Tecnologías Utilizadas
- **Java** 
- **Selenium WebDriver** (para la interacción con la página web)
- **Cucumber** (para pruebas BDD)
- **JUnit/TestNG** (para ejecución de pruebas)
- **Maven** (para la gestión de dependencias)

## 🎯 Funcionalidades Implementadas
- **Registro de usuario:** Rellena el formulario y verifica la creación exitosa.
- **Inicio de sesión:** Ingresa credenciales y valida el acceso correcto.
- **Búsqueda de producto:** Usa la barra de búsqueda y verifica resultados.
- **Gestión de carrito:** Agrega productos, revisa contenido y verifica presencia.
- **Home:** Abre la pagina principal y verifica la URL

  ✅ Consideraciones
- WebDriver: Se recomienda ChromeDriver actualizado.
- Esperas explícitas: Se usan WebDriverWait para evitar fallos por carga lenta.
- XPath optimizado: Se utilizan estrategias confiables para localizar elementos.
- Cierre del navegador: Se ejecuta driver.quit() para liberar recursos después de las pruebas.

📖 Autor
Agustin
🚀 Automatización de pruebas con Selenium & Cucumber

