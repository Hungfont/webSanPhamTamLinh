package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.HoaDonEntity;
public interface OrderRepository extends JpaRepository<HoaDonEntity, Long>{
	List<HoaDonEntity> findOneByUser_Id(Long id);
	Page<HoaDonEntity> findAllByStatus(boolean status,Pageable pageable);
	@Query(value = "SELECT c FROM HoaDonEntity c WHERE c.firstName LIKE %?1% "
			+ "OR c.lastName LIKE %?1% "
			+ "OR c.email LIKE %?1% "
			+ "OR c.address LIKE %?1% "
			+ "OR c.phone LIKE %?1%")
	public Page<HoaDonEntity> search(String keyword,Pageable pageable);
	public Page<HoaDonEntity>  findOneByUser_Id(Long keyword,Pageable pageable);
}
