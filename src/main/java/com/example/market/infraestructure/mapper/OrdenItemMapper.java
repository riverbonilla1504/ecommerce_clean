package com.example.market.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.entity.OrdenItem;

@Mapper(componentModel = "spring")
public interface OrdenItemMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "precioUnitario", target = "unitPrice"),
        @Mapping(source = "producto.id", target = "productId"),
        @Mapping(source = "orden.id", target = "orderId")
    })
    OrderItemDTO toOrderItemDTO(OrdenItem item);

    List<OrderItemDTO> toOrderItemDTOs(List<OrdenItem> items);

    @InheritInverseConfiguration
    OrdenItem toOrdenItem(OrderItemDTO itemDTO);

    List<OrdenItem> toOrdenItems(List<OrderItemDTO> itemDTOs);
}
