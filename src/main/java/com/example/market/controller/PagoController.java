package com.example.market.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.domain.service.PaymentService;

@RestController
@RequestMapping("/ordenes/{ordenId}/pagos")
public class PagoController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAll(@PathVariable Long ordenId) {
        return paymentService.getAllByOrderId(ordenId);
    }

    @PostMapping
    public PaymentDTO create(@PathVariable Long ordenId, @RequestBody PaymentDTO dto) {
        return paymentService.save(ordenId, dto);
    }

    @PutMapping("/{id}")
    public PaymentDTO update(@PathVariable Long ordenId, @PathVariable Long id, @RequestBody PaymentDTO dto) {
        return paymentService.update(ordenId, id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
