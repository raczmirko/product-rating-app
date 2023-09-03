package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Product;
import hu.okrim.productratingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        for (Product product: productRepository.findAll()) {
            productList.add(product);
        }
        return productList;
    }
    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}