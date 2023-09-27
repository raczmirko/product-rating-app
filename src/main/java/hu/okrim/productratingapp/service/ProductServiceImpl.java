package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Product;
import hu.okrim.productratingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
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
        product.removeFlavours();
        productRepository.delete(product);
    }

    @Override
    public List<Product> findTop3ProductsWithMostRatings() {
        return productRepository.findTop3ProductsWithBestRatings();
    }

    @Override
    public List<Double> getRatingAverageForTop3ProductsWithBestRatings() {
        return productRepository.getRatingAverageForTop3ProductsWithBestRatings();
    }

    @Override
    public Page<Product> findAllByName(String name, Pageable request) {
        return productRepository.findAllByName(name, request);
    }
}