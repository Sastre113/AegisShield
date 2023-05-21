package aegis.shield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class AegisShieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(AegisShieldApplication.class, args);
	}

}
