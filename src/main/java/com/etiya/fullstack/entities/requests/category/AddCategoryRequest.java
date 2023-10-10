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
public class AddCategoryRequest {
    @NotBlank()
    @Size(min=3,max=10, message = "{fieldShouldBeMinimum}")
    private String name;
}