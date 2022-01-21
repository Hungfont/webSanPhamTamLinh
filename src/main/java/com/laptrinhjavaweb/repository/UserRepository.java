package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String name, int status);
	UserEntity findOneByEmailAndStatus(String email, int status);
	@Query("SELECT p FROM UserEntity p WHERE p.userName LIKE %?1%"
            + " OR p.fullName LIKE %?1%"
            + " OR p.email LIKE %?1%")
	public Page<UserEntity> search(String keyword,Pageable pageable);
}