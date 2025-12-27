package com.ashok.order.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ashok.order.entity.OrderEntity;
import com.ashok.order.exception.UserNotFoundException;
import com.ashok.order.exception.UserServiceAccessException;
import com.ashok.order.repo.OrderRepo;
import com.ashok.order.dto.OrderRequestDTO;
import com.ashok.order.dto.OrderResponseDTO;

@Service
public class OrderService {
   
   @Autowired
   private OrderRepo repo;
   @Autowired
   private RestTemplate template;
   public OrderResponseDTO saveOrder(OrderRequestDTO request) {
	   URI uri = UriComponentsBuilder.newInstance()
			     .scheme("http")
			     .host("localhost")
			     .port(8082)
			     .path("/isUserExist")
			     .pathSegment(request.userId().toString())
			     .build()
			     .toUri();
	   
	   try {
		   template.getForObject(uri, Boolean.class);
	   }catch(HttpClientErrorException.NotFound ex) {
		   throw new UserNotFoundException("User not foud for Id "+request.userId());
	   }catch (HttpServerErrorException ex) {
		    throw new UserServiceAccessException("User Service error");
	   }catch (ResourceAccessException ex) {
	       throw new UserServiceAccessException("User Service unavailable");
	   }
	   
	   
	   
	   
	   OrderEntity entity = new OrderEntity(request.userId(), request.productName(), request.qty());
	   entity = repo.save(entity);
	   
	   return new OrderResponseDTO(entity.getOrderId(), entity.getUserId(), entity.getProductName(), entity.getQty());
	  
   }
}
