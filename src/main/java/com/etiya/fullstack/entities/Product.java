package com.etiya.fullstack.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="unit_price")
    private float unitPrice;

    @Column(name="stock")
    private int stock;

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;
}