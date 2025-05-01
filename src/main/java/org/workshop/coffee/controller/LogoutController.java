package org.workshop.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.workshop.coffee.domain.Product;
import org.workshop.coffee.repository.SearchRepository;
import org.workshop.coffee.service.ProductService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

@Controller
public class LogoutController {
    @Autowired
    EntityManager em;

    @Autowired
    DataSource dataSource;

    private ProductService productService;
    @Autowired
    public LogoutController(ProductService productService, SearchRepository searchRepository) {
        this.productService = productService;
    }

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
    public List<Product> searchProduct (String input) {
        //create sql query - using input in the string for product_name
        String sql = "SELECT * FROM product WHERE product_name LIKE '%" + input + "%' OR product_description LIKE '%" + input + "%'";
        //create query
        List<Product> products = em.createNativeQuery(sql, Product.class).getResultList();
        //return the list of products
        return products;
    }
}