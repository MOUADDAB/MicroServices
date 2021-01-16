package org.sid.billingservice.web;


import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.Customer;
import org.sid.billingservice.entities.Product;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.repository.Billrepository;
import org.sid.billingservice.repository.ProductitemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    public BillingRestController(Billrepository billrepository, ProductitemRepository productitemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billrepository = billrepository;
        this.productitemRepository = productitemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    private Billrepository billrepository;
    private ProductitemRepository productitemRepository;
    private CustomerRestClient  customerRestClient;
    private ProductItemRestClient productItemRestClient;

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id)
    {
     Bill bill = billrepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
     bill.setCustomer(customer);
      bill.getProductitems().forEach(pi->{
          Product product =productItemRestClient.getProductBuId(pi.getProductID());
//    pi.setProduct(product);
          pi.setProductName(product.getName());
      });
     return bill;
    }

}
