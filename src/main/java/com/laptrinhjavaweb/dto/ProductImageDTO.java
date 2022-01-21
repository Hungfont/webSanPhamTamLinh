package com.laptrinhjavaweb.dto;

public class ProductImageDTO extends AbstractDTO<ProductImageDTO> {
	private String name;
	private String type;
	private String caption;
	private Long productId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
