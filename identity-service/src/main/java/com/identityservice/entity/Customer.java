package com.identityservice.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Customer {

	@Id
	private String cId;
	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;	

	//(cascade = CascadeType.ALL)
	private Address address;
	
//	@JsonIgnore
	//(cascade = CascadeType.ALL)
	private Cart cart;
	
	private List<Orders> orders;
	
}

//"address":{
//    "addressId":1,
//    "streetNo":"abc",
//    "buildingName":"palace",
//    "city":"Kottayam",
//    "state":"Kerala",
//    "country":"India",
//    "pincode":"675746"
//},
//"cart":{
//    "cartId":1,
//    "product_quantity":0
//}

//package com.shyam.identityservice.entity;
//
//import java.util.List;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
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
//public class Customer {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer cId;
//	private String firstName;
//	private String lastName;
//	private String mobile;
//	private String email;
//	private String password;	
//
//	@OneToOne
//	//(cascade = CascadeType.ALL)
//	private Address address;
//	
//	@JsonIgnore
//	@OneToOne
//	//(cascade = CascadeType.ALL)
//	private Cart cart;
//	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
//	private List<Orders> orders;
//	
//}
//
////"address":{
////    "addressId":1,
////    "streetNo":"abc",
////    "buildingName":"palace",
////    "city":"Kottayam",
////    "state":"Kerala",
////    "country":"India",
////    "pincode":"675746"
////},
////"cart":{
////    "cartId":1,
////    "product_quantity":0
////}
