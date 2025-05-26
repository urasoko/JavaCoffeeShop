package nl.brianvermeer.workshop.coffee.controller;

import nl.brianvermeer.workshop.coffee.repository.SearchRepository;
import nl.brianvermeer.workshop.coffee.service.ProductService;
import nl.brianvermeer.workshop.coffee.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    @Autowired
    EntityManager em;
    @Autowired
    private  ProductService productService;


    @GetMapping({"/", "/index", "/home"})
    public String homePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @PostMapping("/")
    public String searchProducts(Model model, @RequestParam String input) {
        model.addAttribute("products", searchProduct(input));
        return "index";
    }

    private List<Product> searchProduct (String input) {
        // TODO: 商品名や説明に基づいて商品を検索する
        return null;
    }

}
