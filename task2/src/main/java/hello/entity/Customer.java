package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

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
    @OneToMany(mappedBy = "customer", targetEntity = Order.class,
            fetch = FetchType.EAGER)
    private Collection orders;

    //конструкторы, геттеры, сеттеры
    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection getOrders() {
        return orders;
    }

    public void setOrders(Collection orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
