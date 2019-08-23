package shop.service.iface;

import org.springframework.stereotype.Service;
import shop.entity.Product;

import java.util.List;
//слой сервиса предметов, интерфейс
@Service
public interface ProductService {
    Product getProductById(long id);

    List<Product> getAllProducts();

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(long id);
}
