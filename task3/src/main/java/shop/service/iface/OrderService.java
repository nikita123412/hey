package shop.service.iface;

import org.springframework.stereotype.Service;
import shop.entity.Order;

import java.util.List;
//слой сервиса заказов, интерфейс
@Service
public interface OrderService {
    Order getOrderById(long id);

    List<Order> getAllOrders();

    List<Order> getAllOrdersByCustomerId(long id);

    Order addOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(long id);
}
