package com.etiya.fullstack.repositories;

import com.etiya.fullstack.entities.Product;
import com.etiya.fullstack.entities.responses.product.GetAllProductResponse;
import com.etiya.fullstack.entities.responses.product.GetProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT new com.etiya.fullstack.entities.responses.product.GetAllProductResponse(p.id, p.name, c.name) From Product p " +
            "JOIN p.category c")
    List<GetAllProductResponse> getAll();

    @Query("SELECT new " +
            "com.etiya.fullstack.entities.responses.product.GetProductResponse(p.id, p.name,c.name,c.id,p.stock,p.unitPrice) " +
            "From Product p " +
            "JOIN p.category c WHERE p.id= :id")
    Optional<GetProductResponse> getById(int id);
}