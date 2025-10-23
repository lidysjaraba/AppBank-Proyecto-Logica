AppBank – Proyecto Lógica

AppBank es una aplicación bancaria desarrollada en Java utilizando el framework Spring Boot, con el objetivo principal de simular la gestión de un sistema bancario básico, 
aplicando principios de programación orientada a objetos, estructuras lógicas y la resolución de problemas a través del diseño modular.

La aplicación permite realizar operaciones comunes como crear clientes y cuentas de ahorro y corriente, realizar depósitos, retiros y transferencias entre cuentas;
la aplicación de intereses y consultas de transacciones y persistencia de datos en archivos JSON mediante un repositorio personalizado.

Este proyecto es un ejemplo de la integración entre la lógica computacional, modelado de objetos y servicios REST, que fomenta el razonamiento estructurado
y la solución de problemas reales en entornos digitales.

La lógica aplicada en este proyecto se basa en principios como:
La abstracción, que se implementa al separar las responsabilidades en clases y métodos específicos.
El encapsulamiento, implementado en la protección de los datos mediante atributos privados y acceso controlado.
El polimorfismo, implementado en comportamientos diferentes en clases derivadas, por ejemplo, se puede evidenciar en la aplicación de intereses.

La organización del código es en paquetes. A nivel de software, el uso del Spring Boot facilita la creación de servicios RESTful que comunica las operaciones lógicas
del sistema con el usuario o herramientas de prueba como Postman.

El proyecto sigue una arquitectura en capas, así:

com.bank.app_bank
│
├── controller/        → Controladores REST que exponen las rutas del API.
├── exception/         → Manejo de excepciones personalizadas.
├── model/             → Clases principales del dominio (Cliente, Cuenta, Transacción, etc.).
├── repository/        → Persistencia de datos en archivos JSON.
├── service/           → Lógica de negocio e implementación de reglas bancarias.
├── service/strategies → Estrategias de cálculo de intereses.
└── util/              → Utilidades para manejo de archivos y JSON.

Estas son las clases principales:

La clase Customer representa un cliente del banco.
Account es una clase abstracta, es la base para las cuentas bancarias de ahorro y corriente.
SavingsAccount es donde se aplica intereses sobre el saldo.
CheckingAccount permite sobregiros hasta un limite definido.
Transactions es donde se registra cada operación realizada, como depósitos, retiros, transferencias…
BankServices / BankServiceIml es donde se implementa la lógica del negocio
BanckController se encarga de gestionar las peticiones HTTP API REST


Para una persona que no conoce mucho de programación, las herramientas utilizadas para este proyecto, instalación y ejecución:

Tener el lenguaje Java en su versión mas reciente instalado en el sistema y configurado
Instalar y configurar Visual Studio Code o IntelliJ IDEA (cualquiera de los dos)
Tener Spring Boot en su versión más reciente, (el Spring Boot se ejecuta automáticamente desde el proyecto
Y por último instalar Postman para las pruebas de endpoints (o Thunder Client que es una extensión de Visual Studio Code para realizar estas pruebas)

En este repositorio donde se encuentra el archivo, se puede clonar y abrir el proyecto en un editor de código como VS Code y desde la terminar del sistema
asegurarse de que el Spring Boot se ejecute, algo como mvn spring-boot:run. Y si todo sale bien debería aparecer en consola una información similar a: Tomcat started on port 8080 (http)
Started AppBankApplication in X.XXX seconds, lo cual confirma que el servidor REST está activo en: http://localhost:8080 (el número de puerto puede variar)

Los endpoints principales del API son:


POST  /api/bank/customers    para crear un nuevo cliente

GET  /api/bank/customers     para listar todos los clientes 

GET  /api/bank/customers/{id}  para poder encontrar un cliente por su ID

POST   /api/bank/customers/{customerId}/accounts   para crear una cuenta asociada a un cliente 

GET   /api/bank/accounts/{accountId}   para consultar una cuenta por ID

POST   /api/bank/accounts/{accountId}/deposit?amount=X   para depositar dinero

POST   /api/bank/accounts/{accountId}/withdraw?amount=X   para retirar dinero

POST    /api/bank/accounts/{fromAccountId}/transfer    para hacer tranferencias entre cuentas 

GET    /api/bank/accounts/{accountId}/transactions    para consultar las transacciones

POST  /api/bank/accounts/{accountId}/apply-interest   para poder aplicar intereses
