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
    @Autowired
    private SearchRepository searchRepository;


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
        // 入力を小文字に変換
        String lowerCaseInput = input.toLowerCase(Locale.ROOT);
        // sqlを作成
        String query = "SELECT * FROM Product WHERE LOWER(description) LIKE '%" + lowerCaseInput + "%' OR LOWER(product_name) LIKE '%" + lowerCaseInput + "%'";
        // クエリを実行して結果を取得
        List<Product> resultList = (List<Product>) em.createNativeQuery(query, Product.class).getResultList();
        // 結果を返す
        return resultList;
    }

}
