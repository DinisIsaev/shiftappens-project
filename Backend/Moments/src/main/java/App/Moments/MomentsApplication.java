package App.Moments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"App"})
public class MomentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MomentsApplication.class, args);
	}

}
