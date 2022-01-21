package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "order_item")
@Entity
public class OrderItemEntity extends BaseEntity{
	@Column
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private HoaDonEntity order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public HoaDonEntity getOrder() {
		return order;
	}

	public void setOrder(HoaDonEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
}
