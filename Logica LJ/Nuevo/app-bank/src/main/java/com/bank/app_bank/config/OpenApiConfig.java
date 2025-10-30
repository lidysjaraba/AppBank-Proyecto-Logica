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
