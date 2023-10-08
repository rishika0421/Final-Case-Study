package com.cartsservice.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartsservice.exception.CartException;
import com.cartsservice.exception.CustomerException;
import com.cartsservice.exception.ProductException;
import com.cartsservice.model.Cart;
import com.cartsservice.model.Customer;
import com.cartsservice.model.Product;
import com.cartsservice.repository.CartRepo;
import com.cartsservice.repository.CustomerRepo;
import com.cartsservice.repository.ProductRepo;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cRepo;

	@Autowired
	private CustomerRepo crRepo;

	@Autowired
	private ProductRepo pRepo;
	
	@Override
	public String getCustomerId(String email) {
		return crRepo.findByEmail(email).getCId();
	}

	@Override
	public Cart addProductToCart(String customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		Customer customer = opt.get();
		Cart cart = customer.getCart();
		int cartId = cart.getCartId();
		if(!cRepo.existsById(cartId)) {
			cRepo.save(cart);
		}
		
		
		

//		List<Product> itemList = cart.getProducts();
	
		 List<Product> itemList = new ArrayList<>();
		itemList = cRepo.findById(cartId).get().getProducts();
		if(itemList == null) {
			itemList = new ArrayList<>();
		}
	
//		    if (itemList == null) {
//		        itemList = new ArrayList<>();
//		boolean flag = false;
//		for (int i = 0; i < itemList.size(); i++) {
//			Product element = itemList.get(i);
//			if (element.getProductId() == productId) {
//				flag = true;
//			}
//		}
//		if(!flag) {
			itemList.add(pRepo.findById(productId).get());
	        cart.setProducts(itemList);
//		}
		        //cRepo.save(cart);
//		    }
//		boolean flag = true;
//		for (int i = 0; i < itemList.size(); i++) {
//			Product element = itemList.get(i);
//			if (element.getProductId() == productId) {
//				if (cart.getProduct_quantity() == null) {
//					cart.setProduct_quantity(1);
//
//				} else {
//					cart.setProduct_quantity(cart.getProduct_quantity() + 1);
//				}
//
//				flag = false;
//			}
//		}
//		if (flag) {
//			cart.getProducts().add(itemOpt.get());
//		}
		cart.setProduct_quantity(itemList.size());
		cRepo.save(cart);
		return cart;

	}
	
	public List<Product> getProductList(String cId){
		Customer customerObj = crRepo.findById(cId).get();
		int cartId = customerObj.getCart().getCartId();
		Cart cartObj = cRepo.findById(cartId).get();
		
		List<Product> productList = new ArrayList<>();
		productList = cartObj.getProducts();
		return productList;
	}

	@Override
	public Cart removeProductFromCart(String customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");
		Customer customer = opt.get();
		Cart cart = customer.getCart();
		int cartId = cart.getCartId();
		
//		List<Product> itemList = cart.getProducts();
		List<Product> itemList = new ArrayList<>();
		itemList = cRepo.findById(cartId).get().getProducts();
		boolean flag = false;
		for (int i = 0; i < itemList.size(); i++) {
			System.out.println("hello ");
			Product element = itemList.get(i);
			if (element.getProductId().equals(productId)) {
				itemList.remove(element);
				flag = true;
				break;
			}
		}
		if (!flag) {
			throw new CartException("Product not removed from cart");
		}
		cart.setProduct_quantity(itemList.size());
		cart.setProducts(itemList);
		cRepo.save(cart);
		return cart;

	}

	@Override
	public Cart removeAllProduct(String customerId) throws CartException, CustomerException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");
		Cart c = opt.get().getCart();
		if (c == null) {
			throw new CartException("cart not found");
		}
		c.getProducts().clear();
		return cRepo.save(c);

	}

	@Override
	public Cart increaseProductQuantity(String customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		Customer customer = opt.get();
		Cart cart = customer.getCart();
		List<Product> itemList = cart.getProducts();
		boolean flag = true;
		for (int i = 0; i < itemList.size(); i++) {
			Product element = itemList.get(i);
			if (element.getProductId() == productId) {
				cart.setProduct_quantity(cart.getProduct_quantity() + 1);
				flag = false;
			}
		}
		if (flag) {
			cart.getProducts().add(itemOpt.get());
		}

		cRepo.save(cart);
		return cart;

	}

	@Override
	public Cart decreaseProductQuantity(String customerId, Integer productId)
			throws CartException, CustomerException, ProductException {
		Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		Customer customer = opt.get();
		Cart cart = customer.getCart();
		List<Product> itemList = cart.getProducts();
		boolean flag = true;
		if (itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				Product element = itemList.get(i);
				if (element.getProductId() == productId) {
					cart.setProduct_quantity(cart.getProduct_quantity() + 1);
					flag = false;
				}
			}
		}

		if (flag) {
			cart.getProducts().add(itemOpt.get());
		}

		cRepo.save(cart);
		return cart;
	}

}