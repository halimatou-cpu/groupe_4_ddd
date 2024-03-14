package use_case.suggestion;

import model.Product;
import model.ProductRepository;
import model.ValueObjectId;

import java.util.ArrayList;
import java.util.List;

public class SuggestProduct {
    private ProductRepository productRepository;

    public SuggestProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getRelatedProducts(ValueObjectId productId) {
        try {
            Product foundProduct = this.productRepository.findProductById(productId);

            List<Product> allProducts = this.productRepository.findAll();
            return foundProduct.relatedProducts(allProducts);
        } catch (Exception e) {
            throw e;
        }
    }

    

    

}
