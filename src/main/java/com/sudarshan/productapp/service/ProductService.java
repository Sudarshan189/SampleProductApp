package com.sudarshan.productapp.service;

import org.springframework.stereotype.Service;

import com.sudarshan.productapp.entity.Product;
import com.sudarshan.productapp.exception.ProductNotFoundException;
@Service
public interface ProductService {

	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public Product findProductById(int productId) throws ProductNotFoundException;

	public void deleteProduct(Product product);

}


