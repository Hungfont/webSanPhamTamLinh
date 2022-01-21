package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAllList(Pageable pageable);
	 ProductDTO save(ProductDTO dto);
	 ProductDTO findById(Long id);
}
