package com.example.market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructure.repositories.ProductoImpl;

public class ProductService {

    @Autowired
    private ProductoImpl productoImpl;

    public List<ProductDTO> getAll() {
        return productoImpl.getAll();
    }   

}
