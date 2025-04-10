package com.example.market.domain.repository;
import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.OrderDTO;

public interface IOrder {
    List<OrderDTO> getAll();
    Optional<OrderDTO> getById(Long id);
    List<OrderDTO> getByClientId(Long clientId);
    OrderDTO save(OrderDTO orderDTO);
    void delete(Long id);
    OrderDTO update(Long id, OrderDTO orderDTO);
}
