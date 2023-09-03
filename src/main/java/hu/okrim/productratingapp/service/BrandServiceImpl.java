package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Brand;
import hu.okrim.productratingapp.repository.BrandRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    BrandRepository brandRepository;
    @Override
    public Brand getBrandById(Integer id) {
        return brandRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Brand with id " + id + " not found"));
    }
    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
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