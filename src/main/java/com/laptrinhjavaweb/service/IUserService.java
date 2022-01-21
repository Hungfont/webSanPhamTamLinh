package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService {
	public UserDTO save(UserDTO dto);
	public UserDTO findById(Long id);
}
