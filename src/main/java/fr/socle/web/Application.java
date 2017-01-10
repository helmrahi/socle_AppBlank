package main.java.fr.socle.web;
import main.java.fr.socle.web.crud.jpa.service.ServiceFacade;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer implements ApplicationRunner  {
 
    @Autowired
    private ServiceFacade userService;;
 
    public static void main(String[] args) {
    	ApplicationContext applicationContext = new SpringApplication(Application.class).run(args);
    	CamelSpringBootApplicationController applicationController = applicationContext.getBean(CamelSpringBootApplicationController.class);
    	//applicationController.blockMainThread();
    }
 
    
    @Override
 	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(Application.class);
     }
    
    public void run(ApplicationArguments arg0) throws Exception {
        userService.doService("insertBatch");
    }
    
    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }
    
 
 
}