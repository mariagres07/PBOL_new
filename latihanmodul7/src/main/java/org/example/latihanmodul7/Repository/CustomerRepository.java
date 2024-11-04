package org.example.latihanmodul7.Repository;

import org.example.latihanmodul7.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
