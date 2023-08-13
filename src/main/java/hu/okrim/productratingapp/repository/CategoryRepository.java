package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Category;
import hu.okrim.productratingapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
