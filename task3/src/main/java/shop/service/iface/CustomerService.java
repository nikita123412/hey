package shop.service.iface;

import org.springframework.stereotype.Service;
import shop.entity.Customer;

import java.util.List;
//слой сервиса покупателей, интерфейс
@Service
public interface CustomerService {
    Customer getCustomerById(long id);

    List<Customer> getCustomerByLastName(String lastName);

    List<Customer> getAllCustomers();

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
