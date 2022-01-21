package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;


@Component
public class UserConverter {
	public UserDTO toDTO(UserEntity dto) {
		UserDTO result = new UserDTO();
		result.setId(dto.getId());
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setEmail(dto.getEmail());
		for( int i=0 ; i<dto.getRoles().size();i++){
			result.setRoleCode(dto.getRoles().get(i).getCode());
		}	
		result.setStatus(dto.getStatus());
		return result;
	}
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setEmail(dto.getEmail());
		result.setFullName(dto.getFullName());
		result.setStatus(dto.getStatus());
		return result;
	}
	public UserEntity toEntity(UserEntity result,UserDTO dto) {
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setEmail(dto.getEmail());
		result.setFullName(dto.getFullName());
		result.setStatus(dto.getStatus());
		return result;
	}
}
