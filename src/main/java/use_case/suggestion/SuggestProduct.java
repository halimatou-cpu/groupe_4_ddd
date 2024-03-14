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
        List<Product> relatedProducts = new ArrayList<Product>();
        try {
            Product foundProduct = this.productRepository.findProductById(productId);

            List<Product> allProducts = this.productRepository.findAll();
            for (Product product : allProducts) {
                if (product.getType() == foundProduct.getType() && !product.getId().equals(foundProduct.getId())){
                    relatedProducts.add(product);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return relatedProducts;
    }

    

}
