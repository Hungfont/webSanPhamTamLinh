package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.entity.roleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserConverter userConverter;
	
	public UserDTO save(UserDTO dto) {
		roleEntity role = roleRepo.findOneByCode(dto.getRoleCode());
		List<roleEntity> listRole = new ArrayList<roleEntity>();
		listRole.add(role);
		UserEntity entity = new UserEntity();
		if(dto.getId() != null) {
			UserEntity oldUser = userRepo.findOne(dto.getId());
			dto.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(10)));
			dto.setStatus(1);
			oldUser.setRoles(listRole);
			entity = userConverter.toEntity(oldUser,dto);
		}else {
			dto.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(10)));
			dto.setStatus(1);
			entity  = userConverter.toEntity(dto);
			entity.setRoles(listRole);
		}
		return userConverter.toDTO(userRepo.save(entity));
	}
	
	public UserDTO findById(Long id) {
		UserEntity entity = userRepo.findOne(id);
		return userConverter.toDTO(entity);
	}
	
}
