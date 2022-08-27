package bg.softuni.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
public class IntroApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntroApplication.class, args);
	}

}
