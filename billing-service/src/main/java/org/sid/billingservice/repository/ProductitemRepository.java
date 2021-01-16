package org.sid.billingservice.repository;

import org.sid.billingservice.entities.Productitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProductitemRepository extends JpaRepository<Productitem,Long> {

    public Collection<Productitem> findByBillId(long id);
}
