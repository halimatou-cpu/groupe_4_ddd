package use_case.suggestion;

/*
prend un produit principal qui vient d'être ajouté au panier
va chercher la liste de tous les produits compatibles
et lui suggère ceux qui peuvent accompagner ce dernier/
Voire même ceux que les utiliseurs achètent souvent avec ce produit

*/

import model.Product;
import model.ProductRepository;
import model.ProductType;

import java.util.ArrayList;
import java.util.List;

public class SuggestProduct {
    private ProductRepository productRepository;

    public SuggestProduct(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // je renvoi la liste de tous les produits compatibles avec moi
    public List<Product> getRelatedProducts(int productId){
        Product foundProduct = this.productRepository.findProductById(productId);

        List<Product> allProducts = this.productRepository.findAll();
        List<Product> relatedProducts = new ArrayList<Product>();
        for(Product product: allProducts) {
            if(product.getType() == foundProduct.getType()){
                relatedProducts.add(product);
            }
        }

        return relatedProducts;
    }

}
