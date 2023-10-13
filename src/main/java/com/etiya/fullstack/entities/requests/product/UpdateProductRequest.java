package com.etiya.fullstack.entities.requests.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequest {
    private int id;
    private int categoryId;
    private int stock;
    private float unitPrice;
    private String name;
}