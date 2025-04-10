package com.example.market.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.infraestructure.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByOrdenId(Long ordenId);
}