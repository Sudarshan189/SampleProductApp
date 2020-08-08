package com.sudarshan.productapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sudarshan.productapp.entity.Product;
import com.sudarshan.productapp.exception.ProductNotFoundException;
import com.sudarshan.productapp.repository.ProductRepository;
import com.sudarshan.productapp.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddProductWhichReturnsProduct() {
		Product product = new Product(12346, "Lenovo 6", "computer", 10000);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.addProduct(product));
	}

	@Test
	public void testUpdateProductWhichReturnsProduct() {
		Product product = new Product(12346, "Lenovo 6", "computer", 10000);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.updateProduct(product));
	}

	@Test
	public void testFindProductByIdWhichReturnsProduct() throws ProductNotFoundException {
		Product product = new Product(12346, "Lenovo 6", "computer", 10000);
		Optional<Product> optionalProduct = Optional.of(product);
		when(productRepository.findById(12346)).thenReturn(optionalProduct);
		assertEquals(product, productService.findProductById(12346));
	}

	@Test
	public void testDeleteProduct() throws ProductNotFoundException {
		Product product = new Product(12346, "Lenovo 6", "computer", 10000);
		productService.deleteProduct(product);
		verify(productRepository, times(1)).delete(product);
	}

}
