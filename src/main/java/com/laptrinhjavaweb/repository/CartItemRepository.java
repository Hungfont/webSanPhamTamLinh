package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CartItemEntity;

public interface CartItemRepository  extends JpaRepository<CartItemEntity, Long>{
	List<CartItemEntity> findOneByUser_Id(Long id);
	Long countByUser_Id(Long id); 
	CartItemEntity findOneByProduct_IdAndUser_Id(Long productId,Long UserId);
}
