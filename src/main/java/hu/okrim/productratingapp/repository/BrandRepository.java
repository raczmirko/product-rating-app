package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Brand;
import hu.okrim.productratingapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
