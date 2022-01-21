package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ProductImageDTO;

public interface IProductImageService {
	List<ProductImageDTO> listAll(Long id);
//	ProductImageDTO save(ProductImageDTO dto, Long id);
	void delete(Long id);
}
