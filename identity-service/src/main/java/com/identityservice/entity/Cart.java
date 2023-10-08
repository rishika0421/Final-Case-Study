package com.identityservice.entity;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cart {

	@Id
	private Integer cartId;
	private Integer product_quantity;
	

	private List<Product> products;
	
	
	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Integer getProduct_quantity() {
		return product_quantity;
	}


	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	//@OneToOne(cascade = CascadeType.MERGE)
	private Customer customer;
	
	
	
}

//package com.shyam.identityservice.entity;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import lombok.Data;
//
//@Data
//@Entity
//public class Cart {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "cartId")
//	private Integer cartId;
//	private Integer product_quantity;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Product> products;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	//@OneToOne(cascade = CascadeType.MERGE)
//	private Customer customer;
//	
//	
//	
//}
