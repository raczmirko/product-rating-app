package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    Brand getBrandById(Integer id);

    void addBrand(Brand brand);

    List<Brand> getAllBrands();

    void deleteBrand(Brand brand);
}
