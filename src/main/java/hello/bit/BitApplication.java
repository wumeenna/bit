package hello.bit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;
import lombok.Setter;






@Getter
@Setter
@SpringBootApplication
public class BitApplication {
	
	private int i = 10;

	public static void main(String[] args) {
		SpringApplication.run(BitApplication.class, args);
	}

}
