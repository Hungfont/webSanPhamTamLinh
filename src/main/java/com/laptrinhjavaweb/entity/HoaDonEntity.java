package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hoadon")
public class HoaDonEntity extends BaseEntity{
	@Column(name ="firstname")
	private String firstName;

	@Column(name ="lastname")
	private String lastName;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="phone")
	private String phone;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="note")
	private String note;
	
	@Column(name ="total")
	private float total;
	
	@Column(name ="status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItemEntity> orderItem = new ArrayList<OrderItemEntity>();

	@OneToMany(mappedBy = "order")
	private List<TransactionEntity> transaction = new ArrayList<TransactionEntity>();
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<TransactionEntity> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<TransactionEntity> transaction) {
		this.transaction = transaction;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<OrderItemEntity> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItemEntity> orderItem) {
		this.orderItem = orderItem;
	}
	
	
}
