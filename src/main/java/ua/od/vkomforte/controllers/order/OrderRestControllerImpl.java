package ua.od.vkomforte.controllers.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.od.vkomforte.domain.Customer;
import ua.od.vkomforte.domain.Order;
import ua.od.vkomforte.repository.CustomerRepository;
import ua.od.vkomforte.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestControllerImpl {
    private final OrderRepository orderRepository ;

    public OrderRestControllerImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    //Операция сохранения юзера в базу данных
    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveOrder(@RequestBody Order order) {

        return orderRepository.save(order);
    }

    //Получение списка юзеров
    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    //Получения юзера по id
    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable long id) {

        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
    }
}
