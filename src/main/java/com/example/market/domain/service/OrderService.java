package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructure.repositories.OrdenImpl;

@Service
public class OrderService {

    @Autowired
    private OrdenImpl ordenImpl;

    public List<OrderDTO> getAll() {
        return ordenImpl.getAll();
    }

    public Optional<OrderDTO> getById(Long id) {
        return ordenImpl.getById(id);
    }

    public List<OrderDTO> getByClientId(Long clientId) {
        return ordenImpl.getByClientId(clientId);
    }

    public OrderDTO save(OrderDTO orderDTO) {
        return ordenImpl.save(orderDTO);
    }

    public void delete(Long id) {
        ordenImpl.delete(id);
    }

    public OrderDTO update(Long id, OrderDTO orderDTO) {
        return ordenImpl.update(id, orderDTO);
    }
}
