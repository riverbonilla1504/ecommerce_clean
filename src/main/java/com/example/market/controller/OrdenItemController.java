package com.example.market.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.service.OrderItemService;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrdenItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItemDTO> getAll(@PathVariable Long ordenId) {
        return orderItemService.getAllByOrderId(ordenId);
    }

    @PostMapping
    public OrderItemDTO create(@PathVariable Long ordenId, @RequestBody OrderItemDTO dto) {
        return orderItemService.save(ordenId, dto);
    }

    @PutMapping("/{id}")
    public OrderItemDTO update(@PathVariable Long ordenId, @PathVariable Long id, @RequestBody OrderItemDTO dto) {
        return orderItemService.update(ordenId, id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderItemService.delete(id);
    }
}
