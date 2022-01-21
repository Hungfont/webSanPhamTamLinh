package com.laptrinhjavaweb.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.OrderItemDTO;
import com.laptrinhjavaweb.entity.HoaDonEntity;
import com.laptrinhjavaweb.entity.OrderItemEntity;

@Component
public class OrderConverter {

	@Autowired
	OrderItemConverter orderItemConverter; 
	
	public OrderDTO toDTO(HoaDonEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setAddress(entity.getAddress());
		dto.setPhone(entity.getPhone());
		dto.setNote(entity.getNote());
		dto.setTotal(entity.getTotal());
		dto.setStatus(entity.isStatus());
		dto.setUserId(entity.getUser().getId());
		List<OrderItemDTO> listOrderItem = new ArrayList<OrderItemDTO>();
		for(OrderItemEntity item : entity.getOrderItem()) {
			OrderItemDTO orderItem = orderItemConverter.toDTO(item);
			listOrderItem.add(orderItem);	
		}
		dto.setOrderItem(listOrderItem);
		return dto;
	}
	public HoaDonEntity toEntity(OrderDTO dto) {
		HoaDonEntity entity = new HoaDonEntity();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		entity.setNote(dto.getNote());
		entity.setTotal(dto.getTotal());
		entity.setStatus(dto.isStatus());
		return entity;
	}
	public HoaDonEntity toEntity(HoaDonEntity entity,OrderDTO dto) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		entity.setNote(dto.getNote());
		entity.setTotal(dto.getTotal());
		entity.setStatus(dto.isStatus());
		return entity;
	}
}
