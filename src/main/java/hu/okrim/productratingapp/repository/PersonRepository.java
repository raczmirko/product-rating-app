package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.id IN (" +
                "SELECT person FROM (" +
                    "SELECT r.person as person, COUNT(r.id) as rating_count " +
                    "FROM Rating r GROUP BY r.person " +
                    "ORDER BY rating_count DESC " +
                    "LIMIT 1)" +
            ")")
    Person findPersonWithMostRatings();

    @Query( "SELECT rating_count FROM (" +
                "SELECT r.person as person, COUNT(r.id) as rating_count " +
                "FROM Rating r GROUP BY r.person " +
                "ORDER BY rating_count DESC " +
                "LIMIT 1)")
    Integer getRatingCountOfPersonWithMostRatings();

}
