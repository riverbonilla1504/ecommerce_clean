package com.example.market.infraestructure.mapper;


import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.infraestructure.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "direccion", target = "address"),
        @Mapping(source = "telefono", target = "phone")
    })
    ClientDTO toClientDTO(Cliente cliente);

    List<ClientDTO> toClientDTOs(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(ClientDTO clientDTO);

    List<Cliente> toClientes(List<ClientDTO> clientDTOs);
}
