import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"es.salesianos.*"})
public class SpringBootWebApp extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
 		return application.sources(SpringBootWebApp.class);
 	}
 
 	public static void main(String[] args) throws Exception {
 		SpringApplication.run(SpringBootWebApp.class, args);
 	}
}
