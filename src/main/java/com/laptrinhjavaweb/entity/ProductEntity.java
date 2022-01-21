package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.DecimalMax;
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	@Column(name = "sku")
	private String sku;


	@Column(name = "title")
	private String title;

	@Column(name = "MetaTitle")
	private String metatitle;

	@Column(name = "summary")
	private String summary;
	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "price")
	private float price;
	

	@Column(name = "discount")
	private float discount;

	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
	

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<ProductImage> images = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<CartItemEntity> cartItem = new ArrayList<CartItemEntity>();
	
	@OneToMany(mappedBy = "product")
	private List<OrderItemEntity> orderItem = new ArrayList<OrderItemEntity>();
	
	public List<OrderItemEntity> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItemEntity> orderItem) {
		this.orderItem = orderItem;
	}

	public List<CartItemEntity> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItemEntity> cartItem) {
		this.cartItem = cartItem;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		this.images = images;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetatitle() {
		return metatitle;
	}

	public void setMetatitle(String metatitle) {
		this.metatitle = metatitle;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
