package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductConverter productConverter;
	@Autowired 
	
	CategoryRepository categoryRepo;
	
	public List<ProductDTO> findAllList(Pageable pageable){
		List<ProductDTO> model = new ArrayList<ProductDTO>();
		List<ProductEntity> entities = productRepo.findAll(pageable).getContent();
		for(ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			model.add(dto);
		}
		return model;
	}
	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		CategoryEntity category = categoryRepo.findById(dto.getCategoryId());
		if(dto.getId() != null) {
			ProductEntity oldEntity = productRepo.findById(dto.getId());
			oldEntity.setCategory(category);
			entity = productConverter.toEntity(oldEntity,dto); 
		}else {
			entity = productConverter.toEntity(dto);
			entity.setCategory(category);
		}
		return productConverter.toDTO(productRepo.save(entity));
	}
	public ProductDTO findById(Long id) {
		return productConverter.toDTO(productRepo.findById(id));
	}
	

	
}
