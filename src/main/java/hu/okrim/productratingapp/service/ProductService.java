package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {

    Product getProductById(Integer id);

    Product addProduct(Product product);

    List<Product> getAllProducts();

    void deleteProduct(Product product);

}
