package com.example.market.domain.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.repositories.OrdenItemImpl;

@Service
public class OrderItemService {

    @Autowired
    private OrdenItemImpl ordenItemImpl;

    public List<OrderItemDTO> getAllByOrderId(Long ordenId) {
        return ordenItemImpl.getAllByOrderId(ordenId);
    }

    public OrderItemDTO save(Long ordenId, OrderItemDTO dto) {
        return ordenItemImpl.save(ordenId, dto);
    }

    public OrderItemDTO update(Long ordenId, Long id, OrderItemDTO dto) {
        return ordenItemImpl.update(ordenId, id, dto);
    }

    public boolean delete(Long id) {
        return ordenItemImpl.delete(id);
    }
}
