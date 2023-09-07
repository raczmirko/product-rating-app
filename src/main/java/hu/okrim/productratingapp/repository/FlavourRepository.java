package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Flavour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavourRepository extends CrudRepository<Flavour, Integer> {
}
