package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CartItemDTO;
import com.laptrinhjavaweb.entity.CartItemEntity;

@Component
public class CartItemConverter {
	public CartItemDTO toDTO(CartItemEntity entity) {
		CartItemDTO dto = new CartItemDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		dto.setPrice(entity.getProduct().getPrice());
		dto.setSku(entity.getProduct().getSku());
		dto.setThumbanil(entity.getProduct().getThumbnail());
		dto.setProductId(entity.getProduct().getId());
		return dto;
	}
	public CartItemEntity toEntity(CartItemDTO dto) {
		CartItemEntity entity = new CartItemEntity();
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	public CartItemEntity toEntity(CartItemEntity entity,CartItemDTO dto) {
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
}
