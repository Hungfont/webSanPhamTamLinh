package com.laptrinhjavaweb.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	private Integer status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), 
								  inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<roleEntity> roles = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<CartItemEntity> cartItem = new ArrayList<CartItemEntity>();
	
	@OneToMany(mappedBy = "user")
	private List<HoaDonEntity> order = new ArrayList<HoaDonEntity>();
	
	@OneToMany(mappedBy = "user")
	private List<TransactionEntity> transaction =  new ArrayList<TransactionEntity>();
	
	public List<HoaDonEntity> getOrder() {
		return order;
	}


	public void setOrder(List<HoaDonEntity> order) {
		this.order = order;
	}


	public List<TransactionEntity> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<TransactionEntity> transaction) {
		this.transaction = transaction;
	}


	public List<CartItemEntity> getCartItem() {
		return cartItem;
	}


	public void setCartItem(List<CartItemEntity> cartItem) {
		this.cartItem = cartItem;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<roleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<roleEntity> roles) {
		this.roles = roles;
	}
}
