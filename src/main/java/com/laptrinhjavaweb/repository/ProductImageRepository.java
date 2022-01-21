package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
	List<ProductImage> findOneByProduct_Id(Long id);
}
