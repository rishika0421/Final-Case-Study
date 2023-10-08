package com.cartsservice.service;

import java.util.List;

import com.cartsservice.exception.CartException;
import com.cartsservice.exception.CustomerException;
import com.cartsservice.exception.OrderException;
import com.cartsservice.model.Orders;

public interface OrderService {

	public Orders addOrder(String cid) throws OrderException, CustomerException, CartException;

	public Orders updateOrder(Orders order) throws OrderException;

	public Orders viewOrder(Integer orderId) throws OrderException;

	public List<Orders> viewAllOrder() throws OrderException;

	public List<Orders> viewAllOrdersByUserId(String cId) throws OrderException;

}
