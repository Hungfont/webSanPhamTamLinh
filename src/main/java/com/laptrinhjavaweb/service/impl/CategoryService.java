package com.laptrinhjavaweb.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;


@Service
public class CategoryService implements ICategoryService{
	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	CategoryConverter categoryConverter;


	public List<CategoryEntity> findAll() {
		return categoryRepo.findAll();
	}
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if(dto.getId() !=null) {
			CategoryEntity oldEntity = categoryRepo.findOne(dto.getId());
			entity = categoryConverter.toEntity(oldEntity,dto);
		}else {
			entity = categoryConverter.toEntity(dto);
		}
		return categoryConverter.toDto(categoryRepo.save(entity));
	}
	
}
