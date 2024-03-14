package model;

import java.util.List;

public interface ProductRepository {
    Product findProductById(ValueObjectId productId);

    List<Product> findAll();
}
