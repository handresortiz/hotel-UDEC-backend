package co.edu.ucundinamarca.negocio.microservice.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicroserviceEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEmailApplication.class, args);
    }

    @Bean
    public Docket MicroserviceEmailApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis( RequestHandlerSelectors.basePackage("co.edu.ucundinamarca.negocio.microservice.email")).build();
    }

}
