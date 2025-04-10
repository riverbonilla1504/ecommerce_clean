package com.example.market.infraestructure.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.domain.repository.OrdenItemRepository;
import com.example.market.domain.repository.OrdenRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.OrdenItem;
import com.example.market.infraestructure.mapper.OrdenItemMapper;

@Repository
public class OrdenItemImpl implements IOrderItem {

    @Autowired
    private OrdenItemRepository ordenItemRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private OrdenItemMapper ordenItemMapper;

    @Override
    public List<OrderItemDTO> getAllByOrderId(Long ordenId) {
        List<OrdenItem> items = ordenItemRepository.findByOrdenId(ordenId);
        return ordenItemMapper.toOrderItemDTOs(items);
    }

    @Override
    public OrderItemDTO save(Long ordenId, OrderItemDTO itemDTO) {
        Optional<Orden> orden = ordenRepository.findById(ordenId);
        if (orden.isEmpty()) return null;
        OrdenItem item = ordenItemMapper.toOrdenItem(itemDTO);
        item.setOrden(orden.get());
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(item));
    }

    @Override
    public OrderItemDTO update(Long ordenId, Long id, OrderItemDTO itemDTO) {
        Optional<OrdenItem> existing = ordenItemRepository.findById(id);
        if (existing.isEmpty()) return null;
        OrdenItem item = ordenItemMapper.toOrdenItem(itemDTO);
        item.setId(id);
        item.setOrden(existing.get().getOrden());
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(item));
    }

    @Override
    public boolean delete(Long id) {
        if (!ordenItemRepository.existsById(id)) return false;
        ordenItemRepository.deleteById(id);
        return true;
    }
}

