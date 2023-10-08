package com.cartsservice.model;
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
	
	private Customer customer;

	public int getCartId() {
		// TODO Auto-generated method stub
		return cartId;
	}

	public void setProducts(List<Product> itemList) {
		// TODO Auto-generated method stub
		this.products=itemList;
		
	}
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	public void setProduct_quantity(int product_quantity) {
		// TODO Auto-generated method stub
		this.product_quantity=product_quantity;
		
	}
	public int getProduct_quantity() {
		// TODO Auto-generated method stub
		return product_quantity;
	}

	

	
	
	
	
}



//package com.shyam.cartsservice.model;
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