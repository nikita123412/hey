package shop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Product;

import java.util.List;

//репозиторий продуктов
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    List<Product> findAll();
}
