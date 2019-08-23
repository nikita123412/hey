package shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.entity.Order;
import shop.service.iface.OrderService;

import java.util.List;

//слой контроллера для заказов
@RestController
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderService orderService;
    //конструктор чтобы подтянулся сервис
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }
    //добавить заказ
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.OK);
    }
    //изменить заказ
    @PutMapping
    public ResponseEntity<Order> editOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
    }
    //получать заказ по ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }
    //получить список всех заказов
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
    //получить список заказов пользователя по его ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<List<Order>> getAllOrdersByCustomerId(@PathVariable long id) {
        return new ResponseEntity<>(orderService.getAllOrdersByCustomerId(id), HttpStatus.OK);
    }
    //удалить заказ по ID
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
    }
}
