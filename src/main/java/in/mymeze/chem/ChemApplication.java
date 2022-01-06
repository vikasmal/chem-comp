package in.mymeze.chem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({"in.mymeze.chem"})
@Slf4j
public class ChemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChemApplication.class, args);
	}

}
