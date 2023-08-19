package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, String> {
}
