package com.ashok.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderId;
    
    Long userId;
    
    String productName;
    
    int qty;
    
    

	public OrderEntity() {
		super();
	}
	
	

	public OrderEntity(Long userId, String productName, int qty) {
		this.userId = userId;
		this.productName = productName;
		this.qty = qty;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
    
    
}
