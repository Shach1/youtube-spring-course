package ru.learning.managerapp.service;


import ru.learning.managerapp.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();
}
