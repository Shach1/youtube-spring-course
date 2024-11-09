package ru.learning.managerapp.repository;

import org.springframework.stereotype.Repository;
import ru.learning.managerapp.entity.Product;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());
}
