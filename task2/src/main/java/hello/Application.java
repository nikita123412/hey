package hello;

import hello.entity.Customer;
import hello.entity.Order;
import hello.entity.Product;
import hello.repo.CustomerRepository;
import hello.repo.OrderRepository;
import hello.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

//аннтоация чтобы все бины подтянулись
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    //запуск приложения
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //тест приложения
    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository,
                                  OrderRepository orderRepository,
                                  ProductRepository productRepository) {
        return (args) -> {
            //сохраняем несколько покупателей
            Customer jack = customerRepository.save(new Customer("Jack", "Bauer"));
            System.out.println(jack.toString());
            Customer chloe = customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));

            //сохраняем несколько продуктов
            Product tv = productRepository.save(new Product("SuperTV", 10000));
            Product toothBrush = productRepository.save(new Product("Electric toothbrush 5000", 1000));
            Product chair = productRepository.save(new Product("Grandma's chair", 5000));

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
            orderRepository.save(new Order(jack, jacksOrder));
            orderRepository.save(new Order(jack, jacksSecondOrder));
            orderRepository.save(new Order(chloe, chloesOrder));


            //все покупатели
            log.info("Покупатели, найденные с помощью findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            //покупатель найденный по ID
            customerRepository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Покупатель найденный с помощью findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            //заказ найденный по ID
            orderRepository.findById(1L)
                    .ifPresent(order -> {
                        log.info("Заказ найденный с помощью findById(1L):");
                        log.info("--------------------------------");
                        log.info(order.toString());
                        log.info("");
                    });
            //предмет найденный по ID
            productRepository.findById(1L)
                    .ifPresent(product -> {
                        log.info("Предмет найденный с помощью findById(1L):");
                        log.info("--------------------------------");
                        log.info(product.toString());
                        log.info("");
                    });
            // все покупатели с фамилией Bauer
            log.info("Покупатели найденные с помощью findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            customerRepository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // все заказы покупателя с ID = 1
            log.info("Заказы найденные с помощью findByCustomer_CustomerId(1L):");
            log.info("--------------------------------------------");
            orderRepository.findByCustomer_CustomerId(1L).forEach(order -> {
                log.info(order.toString());
            });

            log.info("");
        };
    }
}
