package ru.learning.managerapp.repository;

import org.springframework.stereotype.Repository;
import ru.learning.managerapp.entity.Product;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

    public InMemoryProductRepository() {
        IntStream.range(1, 4)
                .forEach(i -> products.add(new Product(
                        i,
                        "Товар №%d".formatted(i),
                        "Описание товара №%d".formatted(i))));
    }

    @Override
    public List<Product> findAll() {
        // Чтобы не дать возможность изменить список продуктов извне, возвращаем его обернутым в Collections.unmodifiableList
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product save(Product product) {
        product.setId(
                products.stream()
                        .map(Product::getId)
                        .max(Integer::compareTo)
                        .orElse(0) + 1
        );
        products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return products.stream()
                .filter(product -> Objects.equals(product.getId(), productId))
                .findFirst();
    }
}
