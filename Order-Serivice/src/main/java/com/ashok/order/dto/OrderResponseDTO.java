package com.ashok.order.dto;

public record OrderResponseDTO(int orderId, Long userId, String productName, int qty) {

}
