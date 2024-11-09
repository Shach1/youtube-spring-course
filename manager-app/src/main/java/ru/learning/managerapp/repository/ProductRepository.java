package ru.learning.managerapp.repository;

import ru.learning.managerapp.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
