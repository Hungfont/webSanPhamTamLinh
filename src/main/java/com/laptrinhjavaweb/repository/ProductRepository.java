package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity  findById(Long id);
	List<ProductEntity> findOneByCategory_id(Long id);
	Page<ProductEntity> findOneByCategory_id(Long id, Pageable pageable);
	Page<ProductEntity> findOneByPrice(float price, Pageable pageable);
	@Query("SELECT p FROM ProductEntity p WHERE p.metatitle LIKE %?1%"
	            + " OR p.price LIKE %?1%"
	            + " OR p.sku LIKE %?1%")
	 public Page<ProductEntity> search(String keyword,Pageable pageable);
	 
	 public List<ProductEntity>	findOneByMetatitleContaining(String metaTitle); 
	 
	 public ProductEntity findOneBySku(String sku);
	 public ProductEntity findOneByTitle(String title);
	 public ProductEntity findOneByMetatitle(String title);
	
}
