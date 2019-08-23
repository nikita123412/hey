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
import shop.entity.Product;
import shop.service.iface.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private final ProductService productService;
    //конструктор чтобы подтянулся сервис
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    //добавить предмет
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }
    //изменить предмет
    @PutMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }
    //получить предмет по ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    //получить список всех предметов
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    //удалить предмет по ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
