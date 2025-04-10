package com.example.market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.infraestructure.repositories.PagoImpl;

@Service
public class PaymentService {

    @Autowired
    private PagoImpl pagoImpl;

    public List<PaymentDTO> getAllByOrderId(Long orderId) {
        return pagoImpl.getAllByOrderId(orderId);
    }

    public PaymentDTO save(Long orderId, PaymentDTO dto) {
        return pagoImpl.save(orderId, dto);
    }

    public PaymentDTO update(Long orderId, Long id, PaymentDTO dto) {
        return pagoImpl.update(orderId, id, dto);
    }

    public boolean delete(Long id) {
        return pagoImpl.delete(id);
    }
}
