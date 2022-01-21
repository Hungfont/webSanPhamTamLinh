package com.laptrinhjavaweb.dto;

import java.util.List;

public class OrderDTO extends AbstractDTO<OrderDTO>{
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String note;
	private float total;
	private boolean status;
	private Long userId;
	private List<OrderItemDTO> orderItem;
	
	public List<OrderItemDTO> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItemDTO> orderItem) {
		this.orderItem = orderItem;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
