package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.ProductResponseDTO;
import com.myorganisation.wearly.dto.ProductrequestDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO CreateProduct(ProductrequestDTO productrequestDTO);
}
