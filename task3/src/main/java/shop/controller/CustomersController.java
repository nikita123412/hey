package shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.entity.Customer;
import shop.service.iface.CustomerService;

import java.util.List;

//слой контроллера для покупателей
@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;
    //конструктор чтобы подтянулся сервис
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }
    //добавить покупателя
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
    }
    //изменить покупателя
    @PutMapping
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }
    //получить покупателя по ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
    //получить список всех покупателей
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    //получить список покупателей по фамилии
    @GetMapping("/lastnames/{lastName}")
    public ResponseEntity<List<Customer>> getAllCustomersByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(customerService.getCustomerByLastName(lastName), HttpStatus.OK);
    }
    //удалить покупателя
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }
}
