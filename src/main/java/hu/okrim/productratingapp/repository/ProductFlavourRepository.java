package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.entity.ProductFlavour;
import org.springframework.data.repository.CrudRepository;

public interface ProductFlavourRepository extends CrudRepository<ProductFlavour, Long> {
}
