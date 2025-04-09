package com.example.market.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.repository.IProduct;
import com.example.market.domain.repository.ProductoRepository;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.mapper.ProductoMapper;

@Repository
public class ProductoImpl implements IProduct {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductDTO> getAll() {

              List<Producto> productos = productoRepository.findAll();
        return productoMapper.toProductDTOs(productos);
  
        //return productoRepository.findAll()
        //    .stream().map(producto -> productoMapper.toProductDTO(producto))
        //    .collect(Collectors.toList());
    }
}
