package com.sudarshan.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudarshan.productapp.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
