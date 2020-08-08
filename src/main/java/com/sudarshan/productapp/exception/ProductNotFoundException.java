package com.sudarshan.productapp.exception;

public class ProductNotFoundException extends Exception {
	
	public ProductNotFoundException() {		
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
