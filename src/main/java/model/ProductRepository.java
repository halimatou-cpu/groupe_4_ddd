package model;

import java.util.List;

public interface ProductRepository {
    Product findProductById(int productId);

    List<Product> findAll();
}
