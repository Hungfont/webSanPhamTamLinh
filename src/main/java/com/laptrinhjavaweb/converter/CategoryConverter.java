package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity entities) {
		CategoryDTO results = new CategoryDTO();
		results.setId(entities.getId());
		results.setName(entities.getName());
		return results;
	}
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity results = new CategoryEntity();
		results.setName(dto.getName());
		return results;
	}
	public CategoryEntity toEntity(CategoryEntity results, CategoryDTO dto) {
		results.setName(dto.getName());
		return results;
	}
}

