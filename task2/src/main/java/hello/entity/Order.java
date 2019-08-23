package hello.entity;

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

@Entity(name = "ORDERS")
public class Order {
    //ID заказа
    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    //Чей заказ
    @ManyToOne(optional = false)
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    private Customer customer;

    //предметы в заказе с промежуточной таблицей
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ORDER_DETAIL",
            joinColumns =
            @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"),
            inverseJoinColumns =
            @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
    )
    private List<Product> productList;

    //конструкторы, геттеры, сеттеры
    public Order() {
    }

    public Order(Customer customer, List<Product> productList) {
        this.customer = customer;
        this.productList = productList;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", productList=" + productList +
                '}';
    }
}
