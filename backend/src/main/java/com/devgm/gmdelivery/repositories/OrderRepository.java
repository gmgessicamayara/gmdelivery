package com.devgm.gmdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgm.gmdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order , Long>{

}
