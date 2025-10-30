🏦 AppBank – Proyecto de Aula (Java Spring Boot)

AppBank es una aplicación bancaria desarrollada con la guía del docente del curso Lógica para Solución de Problemas, como parte de un proyecto académico de aula.
El objetivo principal es aplicar los principios de Programación Orientada a Objetos (POO) y la lógica computacional, mediante la implementación de un sistema bancario funcional que permita gestionar clientes, cuentas y transacciones, demostrando la integración entre la teoría y la práctica del desarrollo de software.

📘 Descripción general

AppBank permite realizar operaciones bancarias fundamentales de forma lógica y estructurada:

👤 Creación de clientes

💳 Creación de cuentas (corriente y ahorro)

💰 Depósitos, retiros y transferencias

📈 Aplicación de intereses en cuentas de ahorro

📋 Consulta de transacciones

💾 Persistencia de datos en archivos JSON

El proyecto refleja la comprensión de los fundamentos de POO, la modularidad del código y la documentación técnica mediante Swagger y Postman.

🧩 Arquitectura del proyecto

El sistema está organizado en capas para mantener una estructura limpia y escalable:

com.bank.app_bank
│
├── controller/        → Controladores REST (endpoints)
├── exception/         → Manejo de excepciones personalizadas
├── model/             → Clases de dominio (Cliente, Cuenta, Transacción, etc.)
├── repository/        → Persistencia de datos (archivos JSON)
├── service/           → Lógica de negocio y reglas bancarias
├── service/strategies → Estrategias para cálculo de intereses
└── util/              → Clases de utilidad para manejo de archivos

⚙️ Tecnologías utilizadas
Tecnología	Descripción
☕ Java 24	Lenguaje principal
🌱 Spring Boot 3.5.7	Framework backend
🧱 Maven	Gestión de dependencias
📘 Springdoc OpenAPI 3	Documentación Swagger
🧪 Postman	Pruebas de endpoints
📂 JSON	Persistencia de datos
🚀 Instalación y ejecución
🔧 Requisitos previos

Tener instalado Java 17 o superior (recomendado Java 24).

Tener instalado Maven.

Usar un IDE como IntelliJ IDEA o Visual Studio Code.

Contar con Postman o la extensión Thunder Client.

▶️ Ejecución del proyecto

Clona el repositorio:

git clone https://github.com/lidysjaraba/AppBank-Proyecto-Logica.git
cd AppBank-Proyecto-Logica


Compila y ejecuta el proyecto:

mvn spring-boot:run


Verifica en la consola un mensaje similar a:

Tomcat started on port 8080 (http)
Started AppBankApplication in X.XXX seconds


Accede a la aplicación:

Swagger UI: http://localhost:8080/swagger-ui.html

API Base: http://localhost:8080/api/bank

🧭 Endpoints principales
Método	Endpoint	Descripción
POST	/api/bank/customers	Crear un nuevo cliente
GET	/api/bank/customers	Listar todos los clientes
GET	/api/bank/customers/{id}	Buscar cliente por ID
POST	/api/bank/customers/{customerId}/accounts	Crear cuenta asociada a un cliente
GET	/api/bank/accounts/{accountId}	Consultar cuenta por ID
POST	/api/bank/accounts/{accountId}/deposit?amount=X	Depositar dinero
POST	/api/bank/accounts/{accountId}/withdraw?amount=X	Retirar dinero
POST	/api/bank/accounts/{fromAccountId}/transfer	Transferir entre cuentas
GET	/api/bank/accounts/{accountId}/transactions	Consultar transacciones
POST	/api/bank/accounts/{accountId}/apply-interest	Aplicar intereses
📄 Implementación de Swagger

El proyecto implementa Swagger UI mediante Springdoc OpenAPI, lo que permite documentar y probar los endpoints directamente desde el navegador.

📚 Dependencia agregada en pom.xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version>
</dependency>

⚙️ Configuración (SwaggerConfig.java)
package com.bank.app_bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bankAppOpenAPI(){
        return new OpenAPI()

        .info(new Info()
                .title("Bank App API")
                .description("API REST para la gestión de clientes, cuentas y transacciones bancarias")
                .version("1.0.0")
                .contact(new Contact()
                        .name("Lidys Esther Jaraba Guerra")
                        .email("lidys.jarabagu@amigo.edu.co")
                        .url("https://github.com/lidysjaraba"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")));
    }
}


📸 Evidencias con Swagger

<img width="1920" height="1080" alt="funcionamiento swagger" src="https://github.com/user-attachments/assets/13e87f9d-fc40-4f8f-a754-dc7829b6e366" />
<img width="1920" height="1080" alt="swagger endpoints" src="https://github.com/user-attachments/assets/8c6f48e7-2772-4193-8054-01381d5e9c40" />
<img width="1920" height="1080" alt="swagger - crear cliente" src="https://github.com/user-attachments/assets/dfb1bb9a-987d-4e8a-a8e0-3d93e1f13b7d" />
<img width="1920" height="1080" alt="swagger - cuenta de ahorros" src="https://github.com/user-attachments/assets/dfadde70-0608-4576-bb0b-9577ff746eb2" />
<img width="1920" height="1080" alt="swagger - cuenta corriente" src="https://github.com/user-attachments/assets/13373112-fcab-4655-a620-4025cf9dcb1c" />
<img width="1920" height="1080" alt="swagger - depositar a la cuenta de ahorros" src="https://github.com/user-attachments/assets/3814ab79-db5b-47d5-b0d1-af4ec6a182ff" />
<img width="1920" height="1080" alt="swagger - mostrar clientes" src="https://github.com/user-attachments/assets/aef8faf0-0fc9-4afb-9d30-40b3f71a1b49" />

<img width="1920" height="1080" alt="swagger - retiro en la cuenta de ahorros" src="https://github.com/user-attachments/assets/eff58eb8-afd9-45ef-bcae-00da7a7c5bc1" />

<img width="1920" height="1080" alt="swagger - transferir a la cuenta corriente" src="https://github.com/user-attachments/assets/9dccb6fa-d980-423d-b464-0721af84670a" />
<img width="1920" height="1080" alt="swagger - transacciones" src="https://github.com/user-attachments/assets/8c021dc1-17a5-48d4-a3de-18b94dc91c98" />




📸 Evidencias con Postman
<img width="1920" height="1080" alt="postman - aplicar intereses" src="https://github.com/user-attachments/assets/7241c7a9-e315-40ef-b79a-6e20f54078d4" />
<img width="1920" height="1080" alt="postman - Buscar cuenta por id" src="https://github.com/user-attachments/assets/f859975d-feba-4c32-99da-fb1fc5627b46" />
<img width="1920" height="1080" alt="postman - consultar las transacciones" src="https://github.com/user-attachments/assets/f1f8a5ed-376b-402b-8db9-9a61342b01ee" />
<img width="1920" height="1080" alt="postman - crear cuenta corriente" src="https://github.com/user-attachments/assets/ceecbc0a-1ce7-4205-8ec3-3dd902d9e32f" />
<img width="1920" height="1080" alt="postman - crear cuenta de ahorro" src="https://github.com/user-attachments/assets/9d8108bb-42c5-4ddf-8e00-50a2347d1e2a" />
<img width="1920" height="1080" alt="postman - Deposito a la cuenta con id A001" src="https://github.com/user-attachments/assets/16a56bec-e048-4617-8715-b1b5938f630f" />
<img width="1920" height="1080" alt="postman - hacer un retiro" src="https://github.com/user-attachments/assets/4483240f-6cba-4a13-93db-66482aa394b6" />
<img width="1920" height="1080" alt="postman - transferencia entre una cuenta a otra" src="https://github.com/user-attachments/assets/54370ca2-688d-4866-9069-a03d01437734" />






🧠 Principios de lógica aplicados

Abstracción: separación de responsabilidades en clases y métodos.

Encapsulamiento: protección de datos mediante atributos privados.

Polimorfismo: comportamiento distinto en clases derivadas (por ejemplo, estrategias de intereses).

Modularidad: división del sistema en paquetes coherentes y reutilizables.

👩‍💻 Autor

Lidys Esther Jaraba Guerra
📧 lidys.jarabagu@amigo.edu.co

🌐 GitHub - lidysjaraba

📅 Última actualización: 29 de octubre de 2025

🏁 Versión

Versión: 1.0.0
Última actualización: Octubre 2025
