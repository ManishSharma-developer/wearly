//package com.myorganisation.wearly.controller;
//
//import com.myorganisation.wearly.dto.ProductResponseDTO;
//import com.myorganisation.wearly.dto.ProductrequestDTO;
//import com.myorganisation.wearly.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    @Autowired
//    ProductService productService;
//
//    @PostMapping
//    public ResponseEntity<ProductResponseDTO> CreateProduct(@RequestBody ProductrequestDTO productrequestDTO){
//        return new ResponseEntity<>(productService.CreateProduct(productrequestDTO), HttpStatusCode.valueOf(201));
//    }
//}
