package consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumeRestApplication {
	
	/**
	 * Note before running:
	 * clone & run this first: https://github.com/spring-guides/quoters
	 * this app use port 8081 (check application.properties)
	 */

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			for(int i=0; i<5; i++) {
				Quote quote = restTemplate.getForObject(
						"http://localhost:8080/api/random", Quote.class);
				log.info("__QUOTE:__" + quote.toString());
			}
		};
	}
}