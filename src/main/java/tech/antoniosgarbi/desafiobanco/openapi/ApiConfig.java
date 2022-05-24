package tech.antoniosgarbi.desafiobanco.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class ApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Desafio Banco GFT")
                        .description("Minha implementação")
                        .version("1.0.0")
                        .license(new License().name("GPLv3")));
    }

}
