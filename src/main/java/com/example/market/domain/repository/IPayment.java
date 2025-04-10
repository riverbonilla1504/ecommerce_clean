package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.PaymentDTO;

public interface IPayment {

    List<PaymentDTO> getAllByOrderId(Long orderId);
    PaymentDTO save(Long orderId, PaymentDTO paymentDTO);
    PaymentDTO update(Long orderId, Long id, PaymentDTO paymentDTO);
    boolean delete(Long id);
}
