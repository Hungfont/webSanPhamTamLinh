package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.OrderConverter;
import com.laptrinhjavaweb.converter.OrderItemConverter;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.CartItemEntity;
import com.laptrinhjavaweb.entity.HoaDonEntity;
import com.laptrinhjavaweb.entity.OrderItemEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CartItemRepository;
import com.laptrinhjavaweb.repository.OrderItemRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IOrderService;

@Service
public class OrderService implements IOrderService{
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderConverter orderConverter;
	
	@Autowired
	CartItemRepository cartItemRepo;
	
	@Transactional
	public  OrderDTO save(OrderDTO dto) {
		HoaDonEntity order= new HoaDonEntity();
//		UserEntity user = userRepo.findOne(dto.getUserId());
//		order.setUser(user);
		order = orderConverter.toEntity(dto);
		List<OrderItemEntity> orderItem = new ArrayList<OrderItemEntity>();
		List<CartItemEntity> cartItem = cartItemRepo.findOneByUser_Id(dto.getUserId());
		for(CartItemEntity item : cartItem) {
			OrderItemEntity orderItemEntity = new OrderItemEntity();
			orderItemEntity.setQuantity(item.getQuantity());
			orderItemEntity.setProduct(item.getProduct());
			orderItemEntity.setOrder(order);
			orderItemRepo.save(orderItemEntity);
			orderItem.add(orderItemEntity);
		}
		order.setOrderItem(orderItem);
		return orderConverter.toDTO(orderRepo.save(order));
	}
	
	
}
