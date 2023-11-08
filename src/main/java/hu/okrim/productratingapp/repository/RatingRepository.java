package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Person;
import hu.okrim.productratingapp.entity.Product;
import hu.okrim.productratingapp.entity.Rating;
import hu.okrim.productratingapp.entity.RatingId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
   @Query("SELECT r FROM Rating r ORDER BY r.date DESC LIMIT 3")
   List<Rating> findThreeLatestRatings();

   @Query("SELECT r FROM Rating r WHERE r.person = :person AND r.product = :product")
   Rating findById(@Param("person") Person person, @Param("product") Product product);

   List<Rating> findAllByOrderByDateDesc();
}
