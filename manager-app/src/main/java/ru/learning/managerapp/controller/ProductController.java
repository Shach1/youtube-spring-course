package ru.learning.managerapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.learning.managerapp.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

}
