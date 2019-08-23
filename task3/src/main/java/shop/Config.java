package shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.repo.CustomerRepository;
import shop.repo.OrderRepository;
import shop.repo.ProductRepository;
import shop.service.iface.CustomerService;
import shop.service.iface.OrderService;
import shop.service.iface.ProductService;
import shop.service.impl.CustomerServiceImpl;
import shop.service.impl.OrderServiceImpl;
import shop.service.impl.ProductServiceImpl;

//конфиг бинов
@Configuration
public class Config {
    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
