package aegis.shield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aegis.shield.util.TestMapper;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class AegisShieldApplication {

	public static void main(String[] args) {
		TestMapper testMapper = new TestMapper();
		
		SpringApplication.run(AegisShieldApplication.class, args);
	}

}
