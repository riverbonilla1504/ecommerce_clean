package com.example.market.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.infraestructure.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
