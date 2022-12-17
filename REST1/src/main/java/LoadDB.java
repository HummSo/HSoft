
import pay.*;
import ord.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {

  private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repo1, OrderRepository repo2) {

	return args -> {
	      repo1.save(new Employee("Bilbo", "Baggins", "burglar"));
	      repo1.save(new Employee("Frodo", "Baggins", "thief"));
	      repo1.findAll().forEach(employee -> log.info("Preloaded " + employee));

	      
	      repo2.save(new Order("MacBook Pro", Status.COMPLETED));
	      repo2.save(new Order("iPhone", Status.IN_PROGRESS));
	      repo2.findAll().forEach(order -> { log.info("Preloaded " + order); });
	};
  }
  /*
  CommandLineRunner initDatabase(EmployeeRepository repo) {

	return args -> {
	      log.info("Preload " + repo.save(new Employee("Bilbo Baggins", "burglar")));
	      log.info("Preload " + repo.save(new Employee("Frodo Baggins", "thief")));
	    };
  }
  */
}