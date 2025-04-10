package com.example.market.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.market.infraestructure.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
