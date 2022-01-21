package com.laptrinhjavaweb.dto;

public class CartItemDTO extends AbstractDTO<CartItemDTO>{
	private int quantity;
	private float price;
	private String sku;
	private String thumbanil;
	private Long productId;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getThumbanil() {
		return thumbanil;
	}
	public void setThumbanil(String thumbanil) {
		this.thumbanil = thumbanil;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
