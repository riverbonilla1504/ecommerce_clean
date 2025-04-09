package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.service.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductService productService;

    public List<ProductDTO> getAll() {
        return productService.getAll();
    }



}
