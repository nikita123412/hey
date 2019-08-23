package shop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Order;

import java.util.List;

//репозиторий заказов
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Override
    List<Order> findAll();

    List<Order> findByCustomerId(long id);
}
