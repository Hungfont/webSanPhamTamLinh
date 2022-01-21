package com.laptrinhjavaweb.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.ProductImageDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.ProductImage;

@Component
public class ProductConverter {
	
	@Autowired
	ProductImageConverter productImageConverter;
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setSku(entity.getSku());
		dto.setTitle(entity.getTitle());
		dto.setMetatitle(entity.getMetatitle());
		dto.setSummary(entity.getSummary());
		dto.setThumbnail(entity.getThumbnail());
		dto.setDiscount(entity.getDiscount());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		dto.setCategoryId(entity.getCategory().getId());
		List<ProductImageDTO> listImg = new ArrayList<>();
		for(ProductImage item : entity.getImages()) {
			ProductImageDTO productImageDTO = productImageConverter.toDTO(item);
			listImg.add(productImageDTO);
		}
		dto.setListImages(listImg);
		return dto;
	}
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setSku(dto.getSku());
		entity.setTitle(dto.getTitle());
		entity.setMetatitle(dto.getMetatitle());
		entity.setSummary(dto.getSummary());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	public ProductEntity toEntity(ProductEntity entity,ProductDTO dto) {
		entity.setSku(dto.getSku());
		entity.setTitle(dto.getTitle());
		entity.setMetatitle(dto.getMetatitle());
		entity.setSummary(dto.getSummary());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		entity.setDiscount(dto.getDiscount());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
}
