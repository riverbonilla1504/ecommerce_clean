package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.repository.IOrder;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.mapper.OrdenMapper;
import com.example.market.domain.repository.OrdenRepository;

@Repository
public class OrdenImpl implements IOrder {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    @Override
    public List<OrderDTO> getAll() {
        return ordenMapper.toOrderDTOs(ordenRepository.findAll());
    }

    @Override
    public Optional<OrderDTO> getById(Long id) {
        return ordenRepository.findById(id)
            .map(ordenMapper::toOrderDTO);
    }

    @Override
    public List<OrderDTO> getByClientId(Long clientId) {
        return ordenMapper.toOrderDTOs(ordenRepository.findByClienteId(clientId));
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Orden orden = ordenMapper.toOrden(orderDTO);
        return ordenMapper.toOrderDTO(ordenRepository.save(orden));
    }

    @Override
    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public OrderDTO update(Long id, OrderDTO orderDTO) {
        Orden orden = ordenMapper.toOrden(orderDTO);
        orden.setId(id);
        return ordenMapper.toOrderDTO(ordenRepository.save(orden));
    }
}

