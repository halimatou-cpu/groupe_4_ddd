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
        try {
            foundProduct = this.productRepository.findProductById(productId);
        } catch (NotFoundException e) {
            throw e;
        }
        List<DogFoodProduct> allProducts = this.productRepository.findAll();

        List<DogFoodProduct> relatedByType = foundProduct.typeBasedSuggestion(allProducts);
        List<DogFoodProduct> relatedByTypeAndBreed = foundProduct.breedBasedSuggestion(relatedByType);
        return relatedByTypeAndBreed;
    }
}
