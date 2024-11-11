package ru.learning.managerapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.learning.managerapp.entity.Product;
import ru.learning.managerapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(int productId) {
        return productRepository.findById(productId);
    }
}
