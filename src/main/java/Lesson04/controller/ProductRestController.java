package Lesson04.controller;

import Lesson04.entities.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getAllProducts(){
        System.out.println("TEST");
        return null;
    }

}
