package co.edu.ucundinamarca.negocio.ServicioProducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ServicioProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProductoApplication.class, args);
	}

        @Bean
    public Docket ServicioProductoServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis( RequestHandlerSelectors.basePackage("co.edu.ucundinamarca.negocio.ServicioProducto")).build();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }
}
