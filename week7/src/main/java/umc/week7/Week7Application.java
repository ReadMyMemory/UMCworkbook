package umc.week7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week7Application {

	public static void main(String[] args) {
		SpringApplication.run(Week7Application.class, args);
	}

}
