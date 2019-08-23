package hello.repo;

import hello.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//репозиторий заказов
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomer_CustomerId(long id);
}
