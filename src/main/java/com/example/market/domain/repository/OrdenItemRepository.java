package com.example.market.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.market.infraestructure.entity.OrdenItem;

public interface OrdenItemRepository extends JpaRepository<OrdenItem, Long> {
    List<OrdenItem> findByOrdenId(Long ordenId);
}
