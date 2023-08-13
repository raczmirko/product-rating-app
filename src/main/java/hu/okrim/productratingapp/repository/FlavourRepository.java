package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface FlavourRepository extends CrudRepository<Flavour, Long> {
}
