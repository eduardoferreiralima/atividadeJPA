package br.com.ifrn.AtividadeJPA.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Informações básicas da API
                .info(new Info()
                        .title("Sistema de Biblioteca - REST API")
                        .version("1.0.0")
                        .description("""
                                Projeto Spring Boot para gerenciar livros, autores, categorias, usuários e empréstimos.
                                Permite consultas específicas, como listar livros por autor ou categoria, empréstimos ativos/atrasados e contagem de livros por categoria.
                                """)
                        .contact(new Contact()
                                .name("Eduardo Lima")
                                .email("ferreira.lima1@escolar.ifrn.edu.br")
                                .url("https://github.com/eduardoferreiralima"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )
                // Servidores disponíveis
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor Local de Desenvolvimento"),
                        new Server()
                                .url("https://api.seusistema.com")
                                .description("Servidor de Produção")
                ))
                // Tags para categorizar os endpoints
                .tags(List.of(
                        new Tag().name("Livro").description("Operações relacionadas a livros"),
                        new Tag().name("Autor").description("Operações relacionadas a autores"),
                        new Tag().name("Usuario").description("Operações relacionadas a usuários"),
                        new Tag().name("Emprestimo").description("Operações relacionadas a empréstimos")
                ))
                // Documentação externa, se necessário
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação do Projeto")
                        .url("https://github.com/eduardoferreiralima/atividadeJPA"))
                // Componentes globais (ex: schemas reutilizáveis)
                .components(new Components());
    }
}
