package hu.okrim.productratingapp.repository;

import hu.okrim.productratingapp.entity.Flavour;
import hu.okrim.productratingapp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.id IN (" +
                "SELECT product FROM (" +
                    "SELECT r.product.id as product, AVG(r.taste + r.smell) as rating_average " +
                    "FROM Rating r " +
                    "GROUP BY r.product.id " +
                    "ORDER BY rating_average DESC " +
                    "LIMIT 3)" +
                ")"
    )
    List<Product> findTop3ProductsWithBestRatings();

    @Query("SELECT rating_average FROM (" +
            "SELECT r.product.id as product, AVG(CAST((r.taste + r.smell) AS double))/2 as rating_average " +
            "FROM Rating r " +
            "GROUP BY r.product.id " +
            "ORDER BY rating_average DESC " +
            "LIMIT 3)"
    )
    List<Double> getRatingAverageForTop3ProductsWithBestRatings();

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE  CONCAT('%', LOWER(:name), '%')")
    Page<Product> findAllByName(@Param("name") String name, Pageable request);

}
