package hello.repo;

import hello.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//репозиторий покупателей
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
