package com.etiya.fullstack.controllers;

import com.etiya.fullstack.entities.requests.category.AddCategoryRequest;
import com.etiya.fullstack.entities.requests.category.UpdateCategoryRequest;
import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;
import com.etiya.fullstack.entities.responses.category.GetCategoryResponse;
import com.etiya.fullstack.services.abstracts.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@SecurityRequirement(name="securityScheme")
@CrossOrigin
public class CategoriesController {
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<GetAllCategoryResponse>> getAll() throws InterruptedException {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetCategoryResponse> getById(@PathVariable int id){
        GetCategoryResponse response = categoryService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid AddCategoryRequest request){
        categoryService.add(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody @Valid UpdateCategoryRequest request){
        categoryService.update(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}