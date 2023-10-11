package com.etiya.fullstack.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@CrossOrigin
@SecurityRequirement(name="securityScheme")
public class ProductsController {
    @GetMapping
    public void getAll(){

    }

    @GetMapping("{id}")
    public void getById(@PathVariable int id){

    }

    @PostMapping
    public void add(){

    }

    @PutMapping()
    public void update(){

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

    }
}