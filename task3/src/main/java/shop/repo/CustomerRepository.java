package shop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Customer;

import java.util.List;

//репозиторий покупателей, все функции реаизованы с помощью "Create, read, update, delete" репозитория
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Override
    List<Customer> findAll();

    List<Customer> findByLastName(String lastName);
}
