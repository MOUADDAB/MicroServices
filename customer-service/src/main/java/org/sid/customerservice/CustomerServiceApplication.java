package org.sid.customerservice;

import com.google.inject.internal.cglib.core.$Customizer;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

   @Bean
	CommandLineRunner start (CustomerRepository customerRepository , RepositoryRestConfiguration restConfiguration){
		return arg ->{
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null, "Mouaddab" , "med@gmail.com"));
            customerRepository.save(new Customer(null ,"Yassine ", "hassan@hmail.com" ));
			customerRepository.save(new Customer(null ,"Salima  ", "Salima@hmail.com" ));
			customerRepository.save(new Customer(null, "mourtadi" , "mourtadi@gmail.com"));
			customerRepository.save(new Customer(null ,"kamal ", "kamal@hmail.com" ));
			customerRepository.save(new Customer(null ,"youssef  ", "youssef@hmail.com" ));
			customerRepository.save(new Customer(null, "ahmed" , "ahmed@gmail.com"));
			customerRepository.save(new Customer(null ,"zakaria ", "zakaria@hmail.com" ));
			customerRepository.save(new Customer(null ,"khalid  ", "khalid@hmail.com" ));
		    customerRepository.findAll().forEach(c->{

			System.out.println(c.toString());
		});
		};
	}
}
