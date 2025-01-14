//substituido pelo spring doc openapi

//package tech.antoniosgarbi.desafiobanco.openapi;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//
//    @Bean
//    public Docket produceApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.any())
//                .build();
//    }
//
//    //versão antiga
//
//    //    @Bean
//    //    public Docket api() {
//    //        return new Docket(DocumentationType.SWAGGER_2)
//    //                .select()
//    //                .apis(RequestHandlerSelectors.any())
//    //                .paths(PathSelectors.any())
//    //                .build()
//    //                .apiInfo(buildApiInfo());
//    //    }
//    //
//    //    private ApiInfo buildApiInfo() {
//    //        return new ApiInfoBuilder()
//    //                .title("Desafio Banco Dio")
//    //                .description("Um projeto criado")
//    //                .version("")
//    //                .contact(new Contact("","",""))
//    //                .build();
//    //    }
//}
