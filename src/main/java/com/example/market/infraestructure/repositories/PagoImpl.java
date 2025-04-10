package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.domain.repository.IPayment;
import com.example.market.domain.repository.OrdenRepository;
import com.example.market.domain.repository.PagoRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.Pago;
import com.example.market.infraestructure.mapper.PagoMapper;

@Repository
public class PagoImpl implements IPayment {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public List<PaymentDTO> getAllByOrderId(Long orderId) {
        List<Pago> pagos = pagoRepository.findByOrdenId(orderId);
        return pagoMapper.toPaymentDTO(pagos);
    }

    @Override
    public PaymentDTO save(Long orderId, PaymentDTO paymentDTO) {
        Optional<Orden> orden = ordenRepository.findById(orderId);
        if (orden.isEmpty()) return null;
        Pago pago = pagoMapper.toPago(paymentDTO);
        pago.setOrden(orden.get());
        return pagoMapper.toPaymentDTO(pagoRepository.save(pago));
    }

    @Override
    public PaymentDTO update(Long orderId, Long id, PaymentDTO paymentDTO) {
        Optional<Pago> existing = pagoRepository.findById(id);
        if (existing.isEmpty()) return null;
        Pago pago = pagoMapper.toPago(paymentDTO);
        pago.setId(id);
        pago.setOrden(existing.get().getOrden());
        return pagoMapper.toPaymentDTO(pagoRepository.save(pago));
    }

    @Override
    public boolean delete(Long id) {
        if (!pagoRepository.existsById(id)) return false;
        pagoRepository.deleteById(id);
        return true;
    }
}
