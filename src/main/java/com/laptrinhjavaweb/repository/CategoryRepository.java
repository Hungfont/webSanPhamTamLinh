package com.laptrinhjavaweb.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity  findById(Long id);

	@Query(value = "SELECT c FROM CategoryEntity c WHERE c.name LIKE %?1%")
	public Page<CategoryEntity> search(String keyword,Pageable pageable);
}
