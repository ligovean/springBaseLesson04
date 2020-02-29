package Lesson04.controller;

import Lesson04.entities.Product;
import Lesson04.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
