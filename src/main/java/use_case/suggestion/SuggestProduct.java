package use_case.suggestion;

import model.Product;
import model.ProductRepository;
import model.ValueObjectId;
import use_case.NotFoundException;

import java.util.List;

public class SuggestProduct {
    private ProductRepository productRepository;

    public SuggestProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getRelatedProducts(ValueObjectId productId) {
        Product foundProduct;
        try {
            foundProduct = this.productRepository.findProductById(productId);
        } catch (NotFoundException e) {
            throw e;
        }
        List<Product> allProducts = this.productRepository.findAll();

        return foundProduct.relatedProducts(allProducts);
    }

    

    

}
