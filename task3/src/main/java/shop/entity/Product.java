package shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //автоматически генерирует конструктор, геттеры, сеттеры
@Entity(name = "PRODUCTS")
public class Product {
    //ID предмета
    @Id
    @Column(name = "PROD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    //имя предмета
    @Column(name = "PROD_NAME")
    private String productName;

    //цена предмета
    private int price;

    public Product() {
    }

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

}
