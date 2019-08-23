package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    //конструкторы, геттеры, сеттеры
    public Product() {
    }

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
