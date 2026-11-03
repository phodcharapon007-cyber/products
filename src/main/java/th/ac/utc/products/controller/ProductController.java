package th.ac.utc.products.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.products.model.Product;
import th.ac.utc.products.service.InMemoryProductService;
import th.ac.utc.products.service.ProductService;

@RestController
public class ProductController {
    private final ProductService productService = new InMemoryProductService();

    @GetMapping("/")
    public String home(){
        return "Hello Product";
    }

    @GetMapping("/about")
    public String about(){
        return "This is about page";
    }

    @GetMapping("/products")
    public List<Product> list() {
        return productService.findAll();
    }
    @GetMapping("/product")
    public Product one(@RequestParam Long id) {
        return productService.findById(id).orElse(null);
    }
    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String keyword) {
        return productService.findByName(keyword);
    }



}
