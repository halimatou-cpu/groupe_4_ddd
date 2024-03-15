package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogFoodProduct { // renamae this class to DogProduct, maybe DogFoodProduct would be more explicit

    private ValueObjectId id;
    private String name;
    private ProductType type;
    private final List<Breed> breeds;

    public DogFoodProduct(ValueObjectId id, String name, ProductType type, List<Breed> breeds) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.breeds = breeds;
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
        return this.breeds;
    }

    public List<DogFoodProduct> typeBasedSuggestion(List<DogFoodProduct> products) {
        List<DogFoodProduct> relatedProducts = new ArrayList<DogFoodProduct>();
        for (DogFoodProduct product : products) {
            if (product.getType() == this.type && !this.equals(product)) {
                relatedProducts.add(product);
            }
        }
        return relatedProducts;
    }

    public List<DogFoodProduct> breedBasedSuggestion(List<DogFoodProduct> products) {
        List<DogFoodProduct> relevantProducts = new ArrayList<DogFoodProduct>();
        // for (DogFoodProduct product : products) {
        //     if (!this.equals(product)) {
        //         for (Breed breed : this.breeds) {
        //             if (product.getBreed().contains(breed)) {
        //                 relevantProducts.add(product);
        //                 break;
        //             }
        //         }
        //     }
        // }
        for (DogFoodProduct product : products) {
            if (!this.equals(product)) {
                List<Breed> commonBreeds = new ArrayList<>(this.breeds);
                commonBreeds.retainAll(product.getBreed());
                if (!commonBreeds.isEmpty()) {
                    relevantProducts.add(product);
                }
            }
        }
        return relevantProducts;
    }
    // Trouver les produits dont les breeds correspondent aux miens
    // Par exemple je suis compatible avec les GERMAN_SHEPHERD et les
    // GOLDEN_RETRIEVER
    // Un autre produit est compatible avec les GERMAN_SHEPHERD et les
    // LABRADOR_RETRIEVER
    // Je peux le suggérer comme produit compatible.
    // animal.getRelevantProducts(products)

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
