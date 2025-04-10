package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.ClientDTO;

public interface ICliente {
    List<ClientDTO> getAll();
    Optional<ClientDTO> getCliente(Long id);
    ClientDTO save(ClientDTO clientDTO);
    void delete(Long id);
    ClientDTO update(Long id, ClientDTO clientDTO);
}