package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Flavour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavourRepository extends CrudRepository<Flavour, Integer> {
    @Query("SELECT f FROM Flavour f WHERE LOWER(f.name) LIKE  CONCAT('%', LOWER(:name), '%')")
    Page<Flavour>findAllByName(@Param("name") String name, Pageable request);
}
