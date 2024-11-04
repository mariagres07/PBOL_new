package org.example.restApi.repository;

import org.example.restApi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}


