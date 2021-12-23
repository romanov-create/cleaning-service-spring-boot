package ua.od.vkomforte.controllers.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ua.od.vkomforte.domain.Order;
import ua.od.vkomforte.dto.orderDTO.OrderCreateDTO;
import ua.od.vkomforte.dto.orderDTO.OrderReadDTO;
import ua.od.vkomforte.dto.orderDTO.OrderUpdateDTO;

import java.util.List;

public interface OrderRestController {
    @Operation(summary = "Get All orders", description = "endpoint for getting All orders", tags = {"Order"})
    List<Order> getAll();


    @Operation(summary = "Get order by Id", description = "endpoint for getting order by ID", tags = {"Order"})
    OrderReadDTO getById(@PathVariable long id);


    @Operation(summary = "Add a new order", description = "endpoint for creating an entity", tags = {"Order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Order already exists")})
    OrderReadDTO saveOrder(OrderCreateDTO orderCreateDto);


    @Operation(summary = "Update order by Id", description = "endpoint for updating order by ID", tags = {"Order"})
    OrderReadDTO updateOrder(@PathVariable("id") long id, @RequestBody OrderUpdateDTO orderUpdateDTO);

}
