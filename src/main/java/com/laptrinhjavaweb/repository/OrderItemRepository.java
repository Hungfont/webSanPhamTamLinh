package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Long>{
	List<OrderItemEntity> findOneByOrder_Id(Long id);
	List<OrderItemEntity> findOneByProduct_Id(Long id);
}
