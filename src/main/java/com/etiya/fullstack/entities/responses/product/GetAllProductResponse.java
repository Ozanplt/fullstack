package com.etiya.fullstack.entities.responses.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllProductResponse {
    private int id;
    private String name;
    private String categoryName;
}