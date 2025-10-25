package br.com.ifrn.AtividadeJPA.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Atividade JPA REST API")
                        .version("1.0.0")
                        .description("""
                                API desenvolvida com Spring Boot.
                                """)
                        .contact(new Contact()
                                .name("Eduardo Lima")
                                .email("eduardo@example.com")
                                .url("https://github.com/eduardolima"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor Local de Desenvolvimento"),
                        new Server()
                                .url("https://api.tradecriptowallet.com")
                                .description("Servidor de Produção (Exemplo)")
                ));
    }
}

