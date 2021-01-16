package org.sid.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {
	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(ProductRepository productRepository , RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null, "Ordinateur", 788, 12));
			productRepository.save(new Product(null, "Imprimante", 88, 129));
			productRepository.save(new Product(null, "Smartphone", 1288, 112));
			productRepository.save(new Product(null, "TELE", 788, 12));
			productRepository.save(new Product(null, "Imprimante", 88, 129));
			productRepository.save(new Product(null, "SMARTTV", 1288, 112));
			productRepository.save(new Product(null, "PC Portable", 788, 12));
			productRepository.save(new Product(null, "Imprimante", 88, 129));
			productRepository.save(new Product(null, "Smartphone", 1288, 112));
			productRepository.save(new Product(null, "SMARTTV", 788, 12));
			productRepository.save(new Product(null, "Portable", 88, 129));
			productRepository.save(new Product(null, "Smartphone", 1288, 112));
			productRepository.findAll().forEach(p -> {
				System.out.println(p.getName());
			});

		};
	}
}

