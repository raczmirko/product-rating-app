package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Brand;
import hu.okrim.productratingapp.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    BrandRepository brandRepository;
    @Override
    public Brand getBrandById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }
    @Override
    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }
    @Override
    public List<Brand> getAllBrands() {
        List<Brand> brandsList = new ArrayList<>();
        for (Brand brand : brandRepository.findAll()) {
            brandsList.add(brand);
        }
        return brandsList;
    }
    @Override
    public void deleteBrand(Brand brand) {
        brandRepository.delete(brand);
    }
}