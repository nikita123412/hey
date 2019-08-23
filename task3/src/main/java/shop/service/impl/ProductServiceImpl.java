package shop.service.impl;

import shop.entity.Product;
import shop.repo.ProductRepository;
import shop.service.iface.ProductService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//имплимитация(реализация) сервиса предметов
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>((Collection)productRepository.findAll());
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);
    }
}
