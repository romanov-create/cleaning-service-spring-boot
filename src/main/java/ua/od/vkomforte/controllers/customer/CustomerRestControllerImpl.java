package ua.od.vkomforte.controllers.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.od.vkomforte.domain.Customer;
import ua.od.vkomforte.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestControllerImpl {
    private final CustomerRepository repository;

    public CustomerRestControllerImpl(CustomerRepository repository) {
        this.repository = repository;
    }
    //Операция сохранения юзера в базу данных
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {

        return repository.save(customer);
    }

    //Получение списка юзеров
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {

        return repository.findAll();
    }

    //Получения юзера по id
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
    }

    //удаление юзера по id
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCustomerById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
