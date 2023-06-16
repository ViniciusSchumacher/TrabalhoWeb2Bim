package br.unipar.trabweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class TesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(geraInfoSwagger())
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.unipar.trabweb"))
          .paths(PathSelectors.any())
          .build();
    }
	
	public ApiInfo geraInfoSwagger() {
		return new ApiInfo("Sistema Spring Boot - Unipar", 
				"Trabalho do Segundo Bimestre de Spring Boot/Swagger feito por Vinicius e William.",
				"1.0", null, "Vinicius Schumacher", null, null);
	}

}
