package shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.entity.Customer;
import shop.entity.Order;
import shop.entity.Product;
import shop.repo.CustomerRepository;
import shop.repo.OrderRepository;
import shop.repo.ProductRepository;

import java.util.ArrayList;
import java.util.List;

//предзагрузка данных
@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository,
                                   OrderRepository orderRepository,
                                   ProductRepository productRepository) {
        return args -> {
            //сохраняем несколько покупателей
            Customer jack = customerRepository.save(new Customer("Jack", "Bauer"));
            log.info("Preloading " + jack);
            Customer chloe = customerRepository.save(new Customer("Chloe", "O'Brian"));
            log.info("Preloading " + chloe);
            log.info("Preloading " + customerRepository.save(new Customer("Kim", "Bauer")));
            log.info("Preloading " + customerRepository.save(new Customer("David", "Palmer")));

            //сохраняем несколько продуктов
            Product tv = productRepository.save(new Product("SuperTV", 10000));
            log.info("Preloading " + tv);
            Product toothBrush = productRepository.save(new Product("Electric toothbrush 5000", 1000));
            log.info("Preloading " + toothBrush);
            Product chair = productRepository.save(new Product("Grandma's chair", 5000));
            log.info("Preloading " + chair);

            //сохраняем несколько списков покупок
            List<Product> jacksOrder = new ArrayList<>();
            jacksOrder.add(tv);
            jacksOrder.add(toothBrush);

            List<Product> chloesOrder = new ArrayList<>();
            chloesOrder.add(tv);
            chloesOrder.add(chair);

            List<Product> jacksSecondOrder = new ArrayList<>();
            jacksSecondOrder.add(toothBrush);

            //сохраняем несколько заказов
            log.info("Preloading " + orderRepository.save(new Order(jack, jacksOrder)));
            log.info("Preloading " + orderRepository.save(new Order(jack, jacksSecondOrder)));
            log.info("Preloading " + orderRepository.save(new Order(chloe, chloesOrder)));
        };
    }
}
