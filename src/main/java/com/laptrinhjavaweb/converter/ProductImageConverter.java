package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductImageDTO;
import com.laptrinhjavaweb.entity.ProductImage;

@Component
public class ProductImageConverter {
	public ProductImageDTO toDTO(ProductImage entity) {
		ProductImageDTO dto = new ProductImageDTO();
		dto.setName(entity.getName());
		dto.setType(entity.getType());
		dto.setCaption(entity.getCaption());
		dto.setProductId(entity.getProduct().getId());
		dto.setId(entity.getId());
		return dto;
	}
	public ProductImage toEntity(ProductImageDTO dto) {
		ProductImage entity = new ProductImage();
		entity.setName(dto.getName());
		entity.setType(dto.getType());
		entity.setCaption(dto.getCaption());
		return entity;
	}

}
