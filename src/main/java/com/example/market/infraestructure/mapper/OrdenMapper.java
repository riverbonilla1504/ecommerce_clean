package com.example.market.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.infraestructure.entity.Orden;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "fecha", target = "date"),
        @Mapping(source = "total", target = "total"),
        @Mapping(source = "estado", target = "status"),
        @Mapping(source = "cliente.id", target = "clientId")
    })
    OrderDTO toOrderDTO(Orden orden);

    List<OrderDTO> toOrderDTOs(List<Orden> ordenes);

    @InheritInverseConfiguration
    Orden toOrden(OrderDTO orderDTO);

    List<Orden> toOrdenes(List<OrderDTO> orderDTOs);
}
