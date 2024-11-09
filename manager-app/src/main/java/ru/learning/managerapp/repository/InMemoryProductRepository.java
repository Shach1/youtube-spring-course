package ru.learning.managerapp.repository;

import org.springframework.stereotype.Repository;
import ru.learning.managerapp.entity.Product;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
}
