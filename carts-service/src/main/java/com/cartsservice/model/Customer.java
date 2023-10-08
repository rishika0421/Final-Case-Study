package com.cartsservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Customer {

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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Id
	private String cId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;

	private Address address;
	
	private Cart cart;
	
	private List<Orders> orders;

	public String getCId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cart getCart() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


//package com.shyam.cartsservice.model;
//
//import java.util.List;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.CascadeType;
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