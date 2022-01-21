package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity{
	@Column(name = "code")
	private String code;
	
	@Column(name ="status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private HoaDonEntity order;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public HoaDonEntity getOrder() {
		return order;
	}

	public void setOrder(HoaDonEntity order) {
		this.order = order;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
