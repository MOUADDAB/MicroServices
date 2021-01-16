package org.sid.inventoryservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestServices {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/listProduct")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    @GetMapping(value = "/listProduct/{id}")
    public Product listProducts(@PathVariable(name = "id")long id) {
        return productRepository.findById(id).get();
    }
    @PutMapping (value = "/listProduct/{id}")
    public Product update(@PathVariable(name = "id")long id ,@RequestBody  Product p) {
        p.setID(id);
        return productRepository.save(p);
    }
    @PostMapping (value = "/listProduct")
    public Product save(@RequestBody  Product p) {

        return productRepository.save(p);
    }
    @DeleteMapping(value = "/listProduct/{id}")
    public void delete(@PathVariable(name = "id")long id) {

         productRepository.deleteById(id);
    }
}
