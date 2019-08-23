package shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity(name = "ORDERS")
public class Order {
    //ID заказа
    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    //чей заказ
    @Column(name ="CUSTOMER_ID")
    private long customerId;

    //предметы в заказе с промежуточной таблицей
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ORDER_DETAIL",
            joinColumns =
            @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"),
            inverseJoinColumns =
            @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
    )
    private List<Product> productList;

    public Order() {
    }

    public Order(Customer customer, List<Product> productList) {
        this.customerId = customer.getCustomerId();
        this.productList = productList;
    }
}
