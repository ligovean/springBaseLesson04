package Lesson04.controller;

import Lesson04.entities.Product;
import Lesson04.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/products")
    public String productList(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    @GetMapping("/productsLess/{cost}")
    public String productListLessPrise(Model model,@PathVariable Double cost) {
        List<Product> allProducts = productService.getAllProductsMin(cost);
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    @GetMapping("/productsGreat/{cost}")
    public String productListGreatPrise(Model model,@PathVariable Double cost) {
        List<Product> allProducts = productService.getAllProductsMax(cost);
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    @RequestMapping("favicon.ico")
    String favicon() {
        return "forward:/resources/favicon.ico";
    }
}
