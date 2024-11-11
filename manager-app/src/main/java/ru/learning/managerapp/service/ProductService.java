package ru.learning.managerapp.service;


import ru.learning.managerapp.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProducts();

    void createProduct(String title, String details);

    Optional<Product> findProduct(int productId);
}
