package ua.od.vkomforte.controllers.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.od.vkomforte.config.mapper.CustomerMapper;
import ua.od.vkomforte.config.mapper.OrderMapper;
import ua.od.vkomforte.domain.Customer;
import ua.od.vkomforte.domain.Order;
import ua.od.vkomforte.dto.customerDTO.CustomerCreateDTO;
import ua.od.vkomforte.dto.customerDTO.CustomerReadDTO;
import ua.od.vkomforte.dto.customerDTO.CustomerUpdateDTO;
import ua.od.vkomforte.dto.orderDTO.OrderCreateDTO;
import ua.od.vkomforte.repository.CustomerRepository;
import ua.od.vkomforte.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestControllerImpl implements CustomerRestController{
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerRestControllerImpl(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @Override
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }


    @Override
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerReadDTO getById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        return CustomerMapper.INSTANCE.toReadDto(customer);
    }

    @Override
    @GetMapping("/customers/firstname/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerReadDTO> getCustomerByFirstName(@PathVariable String firstName) {
        List<Customer> customers = customerService.getCustomersByFirstName(firstName);
        return CustomerMapper.INSTANCE.toReadDtoList(customers);
    }

    @Override
    @GetMapping("/customers/lastname/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerReadDTO> getCustomerByLastName(@PathVariable String lastName) {
        List<Customer> customers = customerService.getCustomersByLastName(lastName);
        return CustomerMapper.INSTANCE.toReadDtoList(customers);
    }

    @Override
    @GetMapping("/customers/phone/{phone}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerReadDTO> getCustomerByPhone(@PathVariable String phone) {
        List<Customer> customers = customerService.getCustomersByPhone(phone);
        return CustomerMapper.INSTANCE.toReadDtoList(customers);
    }

    @Override
    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerReadDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerUpdateDTO requestForUpd) {
        Customer customer = CustomerMapper.INSTANCE.toUpdateCustomer(requestForUpd);
        return CustomerMapper.INSTANCE.toReadDto(customerService.updateCustomer(id, customer));
    }

    @Override
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerReadDTO saveCustomer(@RequestBody CustomerCreateDTO requestForSave) {
        Customer customer = CustomerMapper.INSTANCE.toSaveCustomer(requestForSave);
        return CustomerMapper.INSTANCE.toReadDto(customerService.saveCustomer(customer));
    }


    @Override
    @PatchMapping("/customers/phone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhone(@PathVariable Long id, @RequestParam @NotNull String newPhone) {
        customerService.changePhone(newPhone, id);
    }

    @Override
    @PatchMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerReadDTO removeCustomerById(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomerById(id);
        customerService.removeCustomerById(id);
        return CustomerMapper.INSTANCE.toReadDto(customer);
    }

    @Override
    @PatchMapping("/customers/{id}/orders")
    @ResponseStatus(HttpStatus.OK)
    public OrderCreateDTO addOrderToCustomerByTheirId(@PathVariable long id, OrderCreateDTO requestForSave) {
        Order order = OrderMapper.orderINSTANCE.toSaveOrder(requestForSave);
        return customerRepository.findById(id)
                .map(entity -> {
                    entity.addOrder(order);
                    customerRepository.save(entity);
                    return requestForSave;
                })
                .orElseThrow(() -> new EntityNotFoundException("Entity doesn't exist. Please try again!"));
    }
}
