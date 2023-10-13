package com.etiya.fullstack.controllers;

import com.etiya.fullstack.entities.requests.product.AddProductRequest;
import com.etiya.fullstack.entities.requests.product.UpdateProductRequest;
import com.etiya.fullstack.entities.responses.product.GetAllProductResponse;
import com.etiya.fullstack.entities.responses.product.GetProductResponse;
import com.etiya.fullstack.services.abstracts.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin
@SecurityRequirement(name="securityScheme")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<GetAllProductResponse>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetProductResponse> getById(@PathVariable int id){
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GetProductResponse> add(@RequestBody AddProductRequest request){
        return new ResponseEntity<>(productService.add(request), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<GetProductResponse> update(@RequestBody UpdateProductRequest request){
        return new ResponseEntity<>(productService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        productService.delete(id);
        return  new ResponseEntity(HttpStatus.OK);
    }
}