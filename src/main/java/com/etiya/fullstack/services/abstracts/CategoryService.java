package com.etiya.fullstack.services.abstracts;

import com.etiya.fullstack.entities.requests.category.AddCategoryRequest;
import com.etiya.fullstack.entities.requests.category.UpdateCategoryRequest;
import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;
import com.etiya.fullstack.entities.responses.category.GetCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    GetCategoryResponse getById(int id);
    void add(AddCategoryRequest request);
    void update(UpdateCategoryRequest request);
    void delete(int id);
}