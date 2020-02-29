package Lesson04.controller;

import Lesson04.entities.Product;
import Lesson04.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    //Task1 Список всех Товаров
    @GetMapping("/products")
    public String productList(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    //Task2a Список всех Товаров с ценой ниже указанной в GET-запросе /productsLess/{cost}
    @GetMapping("/productsLess/{cost}")
    public String productListLessPrise(Model model,@PathVariable Double cost) {
        List<Product> allProducts = productService.getAllProductsMin(cost);
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    //Task2b Список всех Товаров с ценой выше указанной в GET-запросе /productsGreat/{cost}
    @GetMapping("/productsGreat/{cost}")
    public String productListGreatPrise(Model model,@PathVariable Double cost) {
        List<Product> allProducts = productService.getAllProductsMax(cost);
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    //Task2c Список всех Товаров с ценой в диапазоне указанном в GET-запросе /productsBetween?costmin={}&costmax={}
    @GetMapping("/productsBetween")
    public String productListBetweenPrise(Model model, @RequestParam("costmin") Double costMin, @RequestParam("costmax") Double costMax) {
        List<Product> allProducts = productService.getAllProductsBetw(costMin,costMax);
        model.addAttribute("products", allProducts);
        System.out.println("TEST");
        return "product-list";
    }


    @RequestMapping("favicon.ico")
    String favicon() {
        return "forward:/resources/favicon.ico";
    }
}
