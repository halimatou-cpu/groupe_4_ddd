package use_case.suggestion;

import model.DogFoodProduct;
import model.ProductRepository;
import model.ValueObjectId;

import java.util.List;

public class SuggestProduct {
    private ProductRepository productRepository;

    public SuggestProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<DogFoodProduct> getRelatedProducts(ValueObjectId productId) {
        DogFoodProduct foundProduct;
        foundProduct = this.productRepository.findProductById(productId);

        List<DogFoodProduct> allProducts = this.productRepository.findAll();

        List<DogFoodProduct> productsWithSameType = foundProduct.getProductsWithSameType(allProducts);
        List<DogFoodProduct> productsWithSameTypeAndBreed = foundProduct.getProductsWithSameBreed(productsWithSameType);
        return productsWithSameTypeAndBreed;
    }
}
