package org.sid.billingservice;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.Customer;
import org.sid.billingservice.entities.Product;
import org.sid.billingservice.entities.Productitem;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.repository.Billrepository;
import org.sid.billingservice.repository.ProductitemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class  BillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(Billrepository billrepository ,
                            ProductitemRepository productitemRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient
    ){
        return args -> {
            Customer customer=customerRestClient.getCustomerById(1L);
          Bill  bill1=billrepository.save(new Bill(null, new Date(), null,customer.getId(),null));
            PagedModel<Product> productPagedModel=productItemRestClient.pageProducts();
           productPagedModel.forEach(p->{
               Productitem productitem=new Productitem();
               productitem.setPrice(p.getPrice());
               productitem.setQuantity(1+new Random().nextInt(100));
               productitem.setBill(bill1);
               productitem.setProductID(p.getId());
               productitemRepository.save(productitem);
           });
        };
    }

}
