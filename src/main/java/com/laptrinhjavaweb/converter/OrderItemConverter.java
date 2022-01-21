package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.OrderItemDTO;
import com.laptrinhjavaweb.entity.OrderItemEntity;

@Component
public class OrderItemConverter {
	public OrderItemDTO toDTO(OrderItemEntity entity) {
		OrderItemDTO dto = new OrderItemDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		dto.setProductId(entity.getProduct().getId());
		dto.setOrderId(entity.getOrder().getId());
		return dto; 
	}
	public OrderItemEntity toEntity(OrderItemDTO dto) {
		OrderItemEntity entity = new OrderItemEntity();
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	public OrderItemEntity toEntity(OrderItemEntity entity,OrderItemDTO dto) {
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
}
