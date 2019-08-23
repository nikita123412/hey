package shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Data //автоматически генерирует конструктор, геттеры, сеттеры
@Entity(name = "CUSTOMERS")
public class Customer {
    //ID покупателя
    @Id
    @Column(name = "CUST_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    //имя покупателя
    @Column(name = "FIRST_NAME")
    private String firstName;

    //фамилия покупателя
    @Column(name = "LAST_NAME")
    private String lastName;

    //заказы покупателя
    @OneToMany
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
