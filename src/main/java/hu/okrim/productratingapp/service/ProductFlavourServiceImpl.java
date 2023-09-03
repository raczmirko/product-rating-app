package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.ProductFlavour;
import hu.okrim.productratingapp.entity.ProductFlavourId;
import hu.okrim.productratingapp.repository.ProductFlavourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFlavourServiceImpl implements ProductFlavourService{
    @Autowired
    private ProductFlavourRepository productFlavourRepository;

    @Override
    public List<ProductFlavour> getAllProductFlavours() {
        List<ProductFlavour> productFlavourList = new ArrayList<>();
        for (ProductFlavour productFlavour: productFlavourRepository.findAll()) {
            productFlavourList.add(productFlavour);
        }
        return productFlavourList;
    }

    @Override
    public ProductFlavour getProductFlavourById(ProductFlavourId id) {
        return productFlavourRepository.findById(id).orElse(null);
    }

    @Override
    public ProductFlavour addProductFlavour(ProductFlavour productFlavour) {
        return productFlavourRepository.save(productFlavour);
    }

    @Override
    public void deleteProductFlavour(ProductFlavourId id) {
        productFlavourRepository.deleteById(id);
    }
}