package com.example.market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructure.repositories.ProductoImpl;


@Service
public class ProductService {

    @Autowired
    private ProductoImpl productoImpl;

    public List<ProductDTO> getAll() {
        return productoImpl.getAll();
    }

    public ProductDTO getById(Long id) {
        return productoImpl.getById(id);
    }

    public ProductDTO save(ProductDTO productDTO) {
        return productoImpl.save(productDTO);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        return productoImpl.update(id, productDTO);
    }

    public boolean delete(Long id) {
        return productoImpl.delete(id);
    }

}
