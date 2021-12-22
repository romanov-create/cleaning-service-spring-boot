package ua.od.vkomforte.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.od.vkomforte.domain.Order;
import ua.od.vkomforte.dto.orderDTO.OrderCreateDTO;
import ua.od.vkomforte.dto.orderDTO.OrderReadDTO;
import ua.od.vkomforte.dto.orderDTO.OrderUpdateDTO;

@Mapper
public interface OrderMapper {
    OrderMapper orderINSTANCE = Mappers.getMapper( OrderMapper.class );

    OrderReadDTO toOrderReadDTO(Order order );
    OrderCreateDTO toOrderSaveDTO(Order order );
    OrderUpdateDTO toOrderUpdateDTO(Order order );

    Order toReadOrder(OrderReadDTO orderReadDTO);
    Order toSaveOrder(OrderCreateDTO orderCreateDTO);
    Order toUpdateOrder(OrderUpdateDTO orderUpdateDTO);
}
