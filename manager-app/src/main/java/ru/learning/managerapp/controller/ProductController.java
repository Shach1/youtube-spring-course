package ru.learning.managerapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.learning.managerapp.controller.payload.UpdateProductPayload;
import ru.learning.managerapp.entity.Product;
import ru.learning.managerapp.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products/{productId:\\d+}")
public class ProductController {     // Занимается обработкой конкретных товаров

    private final ProductService productService;

    // Для методов getProduct и getProductEditPage добавлена новая аннотация @ModelAttribute
    // она позволяет добавить в модель атрибут (productId), который будет доступен во всех методах контроллера
    // для того чтобы не дублировать код
    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId) {
        return productService.findProduct(productId).orElseThrow();
    }

    @GetMapping
    public String getProduct() {
        return "catalogue/products/product";
    }

    @GetMapping("edit")
    public String getProductEditPage() {
        return "catalogue/products/edit";
    }

    @PostMapping("edit")
    public String updateProduct(@ModelAttribute("product") Product product, UpdateProductPayload payload){
        productService.updateProduct(product.getId(), payload.title(), payload.details());
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }

    @PostMapping("delete")
    public String deleteProduct(@ModelAttribute("product") Product product){
        productService.deleteProduct(product.getId());
        return "redirect:/catalogue/products/list";
    }
}
