package org.sid.inventoryservice;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public  interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path = "/byName")
    public List<Product> findByNameContains(@Param("mc") String name);

//    @RestResource(path = "/byNamePage")
//    public Page<Product> findByNameContains(@Param("mc") String name, Pageable pageable);

}
