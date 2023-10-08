package com.identityservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.identityservice.dto.AuthRequest;
import com.identityservice.entity.Address;
import com.identityservice.entity.Customer;
import com.identityservice.repository.AddressRepository;
import com.identityservice.repository.UserCredentialRepository;
import com.identityservice.service.AuthService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;
    
    @Autowired
    UserCredentialRepository customerRepository;
    
//    @Autowired
//    private CartRepository cartRepo; 
    
    @Autowired
    private AddressRepository addRepo;

//    @Autowired
//    private AuthenticationManager authenticationManager;
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomer() 
    {
    	return new ResponseEntity<List<Customer>>(service.getAllCustomer(), HttpStatus.OK);
    }
    
    @GetMapping("/customerById/{cId}")
    public Customer getCustomerById(@PathVariable String cId) {
    	return service.getCustomerById(cId);
    }
    
    @PostMapping("/addAddress")
    public void addAddress(@RequestBody Address address) {
    	addRepo.save(address);
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody Customer user) {
  
        return service.saveUser(user);
    }
    
    @PostMapping("/validate")
	public boolean validateUserDetail(@RequestBody AuthRequest authRequest) {
		return service.validateUserDetail(authRequest);
	}
    
	@PostMapping("/sendVerificationCode")
	public boolean sendVerificationCode(@RequestBody AuthRequest authRequest) {
		return service.sendVerificationCode(authRequest);
	}
	
	@GetMapping("/verifyAccount/{token}")
	public boolean verifyAccount(@PathVariable("token") String confirmationToken) {
		return service.verifyAccount(confirmationToken);
	}
}

//@PostMapping("/addCart")
//public void addAddress(@RequestBody Cart cart) {
//	cartRepo.save(cart);
//}

//@PostMapping("/createCart")
//public void createCart(@RequestParam("customerId") Integer customerId) {
//  // Retrieve the customer based on the customerId (You may need to implement this logic)
//  Customer customer = customerRepository.findById(customerId).get();
//
//  // Create a new Cart instance
//  Cart cart = new Cart();
//  cart.setProduct_quantity(0); // Set the initial quantity as needed
//  cart.setCustomer(customer); // Set the customer reference
//  
//  // Save the Cart instance
//  cartRepo.save(cart);
//}


//@PostMapping("/token")
//public String getToken(@RequestBody AuthRequest authRequest) {
//  Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//  if (authenticate.isAuthenticated()) {
//      return service.generateToken(authRequest.getUsername());
//  } else {
//      throw new RuntimeException("invalid access");
//  }
//}

//@GetMapping("/validate")
//public String validateToken(@RequestParam("token") String token) {
//  service.validateToken(token);
//  return "Token is valid";
//}