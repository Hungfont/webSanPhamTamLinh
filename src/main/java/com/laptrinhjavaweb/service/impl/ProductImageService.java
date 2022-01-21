package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductImageConverter;
import com.laptrinhjavaweb.dto.ProductImageDTO;
import com.laptrinhjavaweb.entity.ProductImage;
import com.laptrinhjavaweb.repository.ProductImageRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductImageService;

@Service
public class ProductImageService implements IProductImageService {
	@Autowired
	ProductImageRepository productImageRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	ProductImageConverter productImageConverter;
	
	public List<ProductImageDTO> listAll(Long id){
		List<ProductImageDTO> model = new ArrayList<ProductImageDTO>();
		List<ProductImage> entity = productImageRepo.findOneByProduct_Id(id);
		for(ProductImage item : entity) {
			ProductImageDTO dto = productImageConverter.toDTO(item);
			model.add(dto);
		}
		return model;
	}
//	public ProductImageDTO save(ProductImageDTO dto, Long id) {
//			ProductImage entity = new ProductImage();
//			ProductEntity productEntity = productRepo.findOne(id);
//			entity.setProduct(productEntity);
//			entity = productImageConverter.toEntity(dto);
//		return productImageConverter.toDTO(productImageRepo.save(entity));
//		
//	}
	public void delete(Long id) {
		productImageRepo.delete(id);
	}
}
