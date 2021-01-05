package com.devgm.gmdelivery.servicies;
 
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgm.gmdelivery.DTO.OrderDTO;
import com.devgm.gmdelivery.DTO.ProductDTO;
import com.devgm.gmdelivery.entities.Order;
import com.devgm.gmdelivery.entities.OrderStatus;
import com.devgm.gmdelivery.entities.Product;
import com.devgm.gmdelivery.repositories.OrderRepository;
import com.devgm.gmdelivery.repositories.ProductRepository;
 

@Service
public class OrderService {


	@Autowired
	private OrderRepository repository;
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional 
	public OrderDTO insert(OrderDTO dto){
		
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
				null, Instant.now(), OrderStatus.PENDING);
		
		for(ProductDTO p: dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}
	 
}
