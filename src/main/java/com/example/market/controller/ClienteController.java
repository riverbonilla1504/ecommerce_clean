package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.service.ClientService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService clienteService;

    @GetMapping
    public List<ClientDTO> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ClientDTO> getById(@PathVariable Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO clientDTO) {
        return clienteService.save(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return clienteService.update(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
