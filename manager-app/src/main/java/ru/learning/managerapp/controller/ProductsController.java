package ru.learning.managerapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.learning.managerapp.controller.payload.NewProductPayload;
import ru.learning.managerapp.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogue/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("list")
    public String getProductsList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {
        productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/list";
    }

    @GetMapping("{productId:\\d+}")
    public String getProduct(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }
}
