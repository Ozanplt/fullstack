package com.etiya.fullstack.entities.requests.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    @Min(1)
    private int id;


    @NotBlank()
    @Size(min=3, message = "Name should be longer than 3 characters.")
    private String name;
}