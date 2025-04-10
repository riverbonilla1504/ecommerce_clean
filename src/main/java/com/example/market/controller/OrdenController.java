package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.service.OrderService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<OrderDTO> getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<OrderDTO> getByClientId(@PathVariable Long clienteId) {
        return orderService.getByClientId(clienteId);
    }

    @PostMapping
    public OrderDTO save(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }

    @PutMapping("/{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.update(id, orderDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
