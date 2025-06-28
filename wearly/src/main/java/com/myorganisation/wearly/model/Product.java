package com.myorganisation.wearly.model;

import com.myorganisation.wearly.model.enums.Category;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String name;
    private String brand;
    private String amount;
}
