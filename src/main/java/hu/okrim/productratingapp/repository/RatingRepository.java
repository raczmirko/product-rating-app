package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.entity.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}