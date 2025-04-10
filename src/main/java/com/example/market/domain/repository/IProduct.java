package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.ProductDTO;
public interface IProduct {

    List<ProductDTO> getAll();
    ProductDTO getById(Long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    boolean delete(Long id);

}
