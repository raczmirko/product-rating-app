package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.ProductFlavour;
import hu.okrim.productratingapp.entity.ProductFlavourId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductFlavourService {
    List<ProductFlavour> getAllProductFlavours();
    ProductFlavour getProductFlavourById(ProductFlavourId id);
    void addProductFlavour(ProductFlavour productFlavour);
    void deleteProductFlavour(ProductFlavourId id);
}