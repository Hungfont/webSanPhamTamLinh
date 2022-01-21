package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.roleEntity;

public interface RoleRepository extends JpaRepository<roleEntity, Long>{
	roleEntity findOneByCode(String code);
}
