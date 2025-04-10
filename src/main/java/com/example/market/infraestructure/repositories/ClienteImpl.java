package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.repository.ClienteRepository;
import com.example.market.domain.repository.ICliente;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.mapper.ClienteMapper;

@Repository
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClientDTO> getAll() {
        return clienteMapper.toClientDTOs(clienteRepository.findAll());
    }

    @Override
    public Optional<ClientDTO> getCliente(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toClientDTO);
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Cliente cliente = clienteMapper.toCliente(clientDTO);
        return clienteMapper.toClientDTO(clienteRepository.save(cliente));
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Cliente cliente = clienteMapper.toCliente(clientDTO);
        cliente.setId(id);
        return clienteMapper.toClientDTO(clienteRepository.save(cliente));
    }
}