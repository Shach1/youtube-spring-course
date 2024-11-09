package ru.learning.managerapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.learning.managerapp.entity.Product;
import ru.learning.managerapp.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
