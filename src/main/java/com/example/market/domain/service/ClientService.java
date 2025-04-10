package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructure.repositories.ClienteImpl;

@Service
public class ClientService {

    @Autowired
    private ClienteImpl clienteImpl;

    public List<ClientDTO> getAll() {
        return clienteImpl.getAll();
    }

    public Optional<ClientDTO> getCliente(Long id) {
        return clienteImpl.getCliente(id);
    }

    public ClientDTO save(ClientDTO clientDTO) {
        return clienteImpl.save(clientDTO);
    }

    public void delete(Long id) {
        clienteImpl.delete(id);
    }

    public ClientDTO update(Long id, ClientDTO clientDTO) {
        return clienteImpl.update(id, clientDTO);
    }
}