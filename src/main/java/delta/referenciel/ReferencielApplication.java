package delta.referenciel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages ="delta.referenciel.Client")
public class ReferencielApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferencielApplication.class, args);
	}

}
