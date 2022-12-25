package or.sid.customerservice;

import or.sid.customerservice.dtos.CustomerRequestDTO;
import or.sid.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("","fouad","fouadelbssita@gmail.com"));
            customerService.save(new CustomerRequestDTO("","ahmed","ahmedenouri@gmail.com"));
        };
    }
}
