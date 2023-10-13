package com.etiya.fullstack.services.abstracts;

import com.etiya.fullstack.entities.Product;
import com.etiya.fullstack.entities.requests.product.AddProductRequest;
import com.etiya.fullstack.entities.requests.product.UpdateProductRequest;
import com.etiya.fullstack.entities.responses.product.GetAllProductResponse;
import com.etiya.fullstack.entities.responses.product.GetProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    GetProductResponse getById(int id);
    GetProductResponse add(AddProductRequest request);
    GetProductResponse update(UpdateProductRequest request);
    void delete(int id);
}