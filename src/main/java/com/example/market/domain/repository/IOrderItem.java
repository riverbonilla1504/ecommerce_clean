package com.example.market.domain.repository;


import java.util.List;

import com.example.market.domain.dto.OrderItemDTO;

public interface IOrderItem {

    List<OrderItemDTO> getAllByOrderId(Long ordenId);
    OrderItemDTO save(Long ordenId, OrderItemDTO itemDTO);
    OrderItemDTO update(Long ordenId, Long id, OrderItemDTO itemDTO);
    boolean delete(Long id);
}
