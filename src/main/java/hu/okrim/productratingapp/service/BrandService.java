package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BrandService {
    Brand getBrandById(Integer id);

    Brand addBrand(Brand brand);

    List<Brand> getAllBrands();

    void deleteBrand(Brand brand);
}
