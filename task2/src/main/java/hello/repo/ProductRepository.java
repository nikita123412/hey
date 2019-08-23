package hello.repo;

import hello.entity.Product;
import org.springframework.data.repository.CrudRepository;

//репозиторий продуктов
public interface ProductRepository extends CrudRepository<Product, Long> {
}
