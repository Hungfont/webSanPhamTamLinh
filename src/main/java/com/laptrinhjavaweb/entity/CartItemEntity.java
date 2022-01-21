package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart_item")
public class CartItemEntity extends BaseEntity{
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	
}

