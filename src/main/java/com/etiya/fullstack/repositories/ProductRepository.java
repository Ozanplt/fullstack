package com.etiya.fullstack.repositories;

import com.etiya.fullstack.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}