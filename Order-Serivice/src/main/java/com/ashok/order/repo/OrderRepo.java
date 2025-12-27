package com.ashok.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.order.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{

}
