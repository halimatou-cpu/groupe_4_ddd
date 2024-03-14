package use_case;

import infra.FakeProductRepositoryImp;
import model.Product;
import model.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.suggestion.SuggestProduct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggestProductTest {
    private ProductRepository productRepo;
    private SuggestProduct suggestProduct;

    private static final int idOfValidProductWithMultipleRelated = 12;
    private static final int idOfValidProduct = 25;
    private static final int idOfInvalidProduct = 5;

    @BeforeEach
    void setUp() {
        productRepo = new FakeProductRepositoryImp();
        suggestProduct = new SuggestProduct(productRepo);
    }

    @Test
    public void whenInvalidId_thenProductNotFound() {
        try {
            List<Product> relatedProducts = suggestProduct.getRelatedProducts(idOfInvalidProduct);
        } catch (NotFoundException e) {
            assertEquals(e.getMessage(), "Product not found with id: " + idOfInvalidProduct);
        }
    }

    @Test
    void no_related_product() {
       List<Product> relatedProducts = suggestProduct.getRelatedProducts(idOfValidProduct);
       assertEquals(relatedProducts.size(), 0);
    }

    @Test
    void one_related_product() {
        List<Product> relatedProducts = suggestProduct.getRelatedProducts(idOfValidProductWithMultipleRelated);
        assertEquals(relatedProducts.size(), 2);
    }
}
