package com.devgm.gmdelivery.controllers;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgm.gmdelivery.DTO.OrderDTO;
import com.devgm.gmdelivery.DTO.ProductDTO;
import com.devgm.gmdelivery.servicies.OrderService;
import com.devgm.gmdelivery.servicies.ProductService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
}
