package com.devgm.gmdelivery.servicies;
 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgm.gmdelivery.DTO.OrderDTO;
import com.devgm.gmdelivery.entities.Order;
import com.devgm.gmdelivery.repositories.OrderRepository;
 

@Service
public class OrderService {


	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	 
}
