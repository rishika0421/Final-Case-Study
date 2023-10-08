package com.identityservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document
public class Orders {

	@Id
	private Integer orderId;
	private LocalDateTime date;
	private String orderStatus;
	private double totalPrice; 

	@JsonIgnore
	private Customer customer;

	private List<Product> productList;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//(cascade = CascadeType.ALL)
	private Address address;
}

//package com.shyam.identityservice.entity;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Embedded;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import lombok.Data;
//
//@Data
//@Entity
//public class Orders {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer orderId;
//	private LocalDateTime date;
//	private String orderStatus;
//	private double totalPrice; 
//
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Customer customer;
//
//	@Embedded
//	@ElementCollection
//	private List<Product> productList;
//
//	@JsonIgnore
//	@OneToOne
//	//(cascade = CascadeType.ALL)
//	private Address address;
//}