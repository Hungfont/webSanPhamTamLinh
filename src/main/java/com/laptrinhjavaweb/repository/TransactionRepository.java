package com.laptrinhjavaweb.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>{
	Page<TransactionEntity> findAllByStatus(boolean status, Pageable pageable);
	TransactionEntity findOneByOrder_Id(long id);
	
	@Query(value = "SELECT c FROM TransactionEntity c WHERE c.code LIKE %?1% "
			+ "OR c.order.id LIKE %?1%")
	public Page<TransactionEntity> search(String keyword,Pageable pageable);
}
