package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.ProductResponseDTO;
import com.myorganisation.wearly.dto.ProductrequestDTO;
import com.myorganisation.wearly.model.Product;
import com.myorganisation.wearly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


        @Autowired
        ProductRepository productRepository;


    @Override
    public ProductResponseDTO CreateProduct(ProductrequestDTO productrequestDTO) {
        Product  product = new Product();
        product.setName(productrequestDTO.getName());
        product.setBrand(productrequestDTO.getBrand());
        product.setAmount(productrequestDTO.getAmount());
        product.setCategory(productrequestDTO.getCategory());

        productRepository.save(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(product.getName());
        productResponseDTO.setId(product.getId());
        productResponseDTO.setAmount(product.getAmount());
        productResponseDTO.setBrand(product.getBrand());
        productResponseDTO.setCategory(product.getCategory());

        return productResponseDTO;
    }
}
