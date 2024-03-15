package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogFoodProduct { // renamae this class to DogProduct, maybe DogFoodProduct would be more explicit

    private ValueObjectId id;
    private String name;
    private ProductType type;
    private final List<Breed> breed;

    public DogFoodProduct(ValueObjectId id, String name, ProductType type, List<Breed> breed){
        this.id = id;
        this.name = name;
        this.type = type;
        this.breed = breed;
    }

    public ProductType getType() {
        return this.type;
    }

    public ValueObjectId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public List<Breed> getBreed() {
        return this.breed;
    }

    public List<DogFoodProduct> relatedProducts(List<DogFoodProduct> products) {
        List<DogFoodProduct> relatedProducts = new ArrayList<DogFoodProduct>();
        for (DogFoodProduct product : products) {
            if (product.getType() == this.getType() && !product.getId().equals(this.getId())){
                relatedProducts.add(product);
            }
        }
        return relatedProducts;
    }
    // Trouver les produits dont les breeds correspondent aux miens 
    // Par exemple je suis compatible avec les GERMAN_SHEPHERD et les GOLDEN_RETRIEVER
    // Un autre produit est compatible avec les GERMAN_SHEPHERD et les LABRADOR_RETRIEVER
    // Je peux le suggérer comme produit compatible.
    // animal.getRelevantProducts(products) 
    /*
      getRelevantProducts(products) {
        List<Product> relevantProducts = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getBreed().containsAll(this.getBreed()) && !product.getId().equals(this.getId())){
                relevantProducts.add(product);
            }
        }
        return relevantProducts;
      }
    */

    @Override
    public boolean equals(Object o) {
        DogFoodProduct product = (DogFoodProduct) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
