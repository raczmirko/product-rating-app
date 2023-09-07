package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
}
