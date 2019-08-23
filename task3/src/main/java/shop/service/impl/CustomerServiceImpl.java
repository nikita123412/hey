package shop.service.impl;

import shop.entity.Customer;
import shop.repo.CustomerRepository;
import shop.service.iface.CustomerService;

import java.util.List;
//имплимитация(реализация) сервиса покупателей
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customerRepository.delete(customer);
    }
}
