package api;

import domain.PathHandlerUseCase;
import storage.SomeSpringPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemocontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocontrollerApplication.class, args);
	}

	@Bean
	public PathHandlerUseCase useCase() {
		return new PathHandlerUseCase(getPort());
	}

	@Bean
	public SomeSpringPort getPort() {
		return new SomeSpringPort();
	}

}
