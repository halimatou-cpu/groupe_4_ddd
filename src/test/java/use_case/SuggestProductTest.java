package use_case;

import infra.FakeProductRepositoryImp;
import model.DogFoodProduct;
import model.ProductRepository;
import model.ValueObjectId;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import use_case.suggestion.NotFoundException;
import use_case.suggestion.SuggestProduct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggestProductTest {
    private ProductRepository productRepo;
    private SuggestProduct suggestProduct;

    private static final ValueObjectId idOfValidProductWithMultipleRelated = new ValueObjectId(12);
    private static final ValueObjectId idOfValidProduct = new ValueObjectId(25);
    private static final ValueObjectId idOfInvalidProduct = new ValueObjectId(5);

    @BeforeEach
    void setUp() {
        productRepo = new FakeProductRepositoryImp();
        suggestProduct = new SuggestProduct(productRepo);
    }

    @Test
    public void whenInvalidId_thenProductNotFound() {
        try {
            suggestProduct.getRelatedProducts(idOfInvalidProduct);
        } catch (NotFoundException e) {
            assertEquals(e.getMessage(), "Product not found with id: " + idOfInvalidProduct);
        }
    }

    @Test
    void no_related_product() {
       List<DogFoodProduct> relatedProducts = suggestProduct.getRelatedProducts(idOfValidProduct);
       assertEquals(relatedProducts.size(), 0);
    }

    @Test
    void many_related_product() {
        List<DogFoodProduct> relatedProducts = suggestProduct.getRelatedProducts(idOfValidProductWithMultipleRelated);
        assertEquals(relatedProducts.size(), 2);
    }
}
