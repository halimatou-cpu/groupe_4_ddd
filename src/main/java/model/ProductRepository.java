package model;

import java.util.List;

public interface ProductRepository {
    DogFoodProduct findProductById(ValueObjectId productId);

    List<DogFoodProduct> findAll();
}
