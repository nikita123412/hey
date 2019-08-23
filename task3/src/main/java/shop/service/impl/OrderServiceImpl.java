package shop.service.impl;

import shop.entity.Order;
import shop.repo.OrderRepository;
import shop.service.iface.OrderService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//имплимитация(реализация) сервиса заказов
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>((Collection) orderRepository.findAll());
    }

    @Override
    public List<Order> getAllOrdersByCustomerId(long id) {
        return orderRepository.findByCustomerId(id);
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(long id) {
        Order order = orderRepository.findById(id).orElse(null);
        orderRepository.delete(order);
    }
}
