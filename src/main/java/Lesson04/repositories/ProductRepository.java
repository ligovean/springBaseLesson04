package Lesson04.repositories;

import Lesson04.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product>findAll();

    List<Product>findAllByCostLessThanEqual(Double cost);

    List<Product>findAllByCostGreaterThanEqual(Double cost);

    List<Product>findAllByCostBetween(Double costMin, Double costMax);
}
