package com.laptrinhjavaweb.dto;

import java.util.List;

public class ProductDTO extends AbstractDTO<ProductDTO>{
	private String sku;
	private String title;
	private String metatitle;
	private String summary;
	private String thumbnail;
	private float price;
	private float discount;
	private int quantity;
	private Long categoryId;
	private List<ProductImageDTO> listImages;
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
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getMetatitle() {
		return metatitle;
	}
	public void setMetatitle(String metatitle) {
		this.metatitle = metatitle;
	}
	public List<ProductImageDTO> getListImages() {
		return listImages;
	}
	public void setListImages(List<ProductImageDTO> listImages) {
		this.listImages = listImages;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
