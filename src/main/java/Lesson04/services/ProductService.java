package Lesson04.services;

import Lesson04.entities.Product;
import Lesson04.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsMin(Double maxCost) {
        return productRepository.findAllByCostLessThanEqual(maxCost);
    }

    public List<Product> getAllProductsMax(Double maxCost) {
        return productRepository.findAllByCostGreaterThanEqual(maxCost);
    }
}
