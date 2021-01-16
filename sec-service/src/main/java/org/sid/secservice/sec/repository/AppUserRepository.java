package org.sid.secservice.sec.repository;

import org.sid.secservice.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
     AppUser findByUsername(String username);
}
