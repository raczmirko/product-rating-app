package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
