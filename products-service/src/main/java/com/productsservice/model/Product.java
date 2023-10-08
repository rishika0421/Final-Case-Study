package com.productsservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private Double price;
	private String color;
	@Lob
	@Column(name = "image", columnDefinition = "BLOB")
	private byte[] image;
	private String dimension;
	private String specification;
	private String menufacturer;
//	@ManyToOne(cascade = CascadeType.ALL)
	private String category;
	
	public Product() {
		
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getMenufacturer() {
		return menufacturer;
	}

	public void setMenufacturer(String menufacturer) {
		this.menufacturer = menufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(Integer productId2, String productName2, double price2, String color2, byte[] image2,
			String dimension2, String specification2, String menufacturer2,String category2) {
		// TODO Auto-generated constructor stub
		productId=productId2;
		productName=productName2;
		price=price2;
		color=color2;
		image=image2;
		dimension=dimension2;
		specification=specification2;
		menufacturer=menufacturer2;
		category=category2;
	}

//	@ManyToOne(cascade = CascadeType.ALL)
//	private Category category;
}