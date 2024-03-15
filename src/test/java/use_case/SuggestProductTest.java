package use_case;

import infra.FakeProductRepositoryImp;
import model.DogFoodProduct;
import model.ProductRepository;
import model.ProductType;
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

    private static final ValueObjectId idOfValidProductWithManySimilarProducts = new ValueObjectId(12);
    private static final ValueObjectId idOfValidProduct = new ValueObjectId(25);
    private static final ValueObjectId idOfInvalidProduct = new ValueObjectId(5);

    @BeforeEach
    void setUp() {
        productRepo = new FakeProductRepositoryImp();
        suggestProduct = new SuggestProduct(productRepo);
    }

    @Test
    public void inexistant_product_causes_an_error() {
        try {
            suggestProduct.getRelatedProducts(idOfInvalidProduct);
        } catch (NotFoundException e) {
            assertEquals(e.getMessage(), "Product not found with id: " + idOfInvalidProduct);
        }
    }

    @Test
    void has_any_related_product() {
       List<DogFoodProduct> relatedProducts = suggestProduct.getRelatedProducts(idOfValidProduct);
       assertEquals(relatedProducts.isEmpty(), true);
    }

    @Test
    void should_find_related_products_of_a_valid_product() {
        List<DogFoodProduct> relatedProducts = suggestProduct.getRelatedProducts(idOfValidProductWithManySimilarProducts);
        assertEquals(relatedProducts.size(), 2);
        assertEquals(relatedProducts.get(0).getId().id(), 13);
        assertEquals(relatedProducts.get(1).getId().id(), 14);
        assertEquals(relatedProducts.get(0).getType(), ProductType.DRYFOOD);
        assertEquals(relatedProducts.get(1).getType(), ProductType.DRYFOOD);
    }
}
