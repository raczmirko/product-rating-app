package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.ProductFlavour;
import hu.okrim.productratingapp.entity.ProductFlavourId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFlavourRepository extends CrudRepository<ProductFlavour, ProductFlavourId> {
}