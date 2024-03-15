package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogFoodProduct { 

    private ValueObjectId id;
    private ProductType type;
    private final List<Breed> breeds;

    public DogFoodProduct(ValueObjectId id, ProductType type, List<Breed> breeds) {
        this.id = id;
        this.type = type;
        this.breeds = breeds;
    }

    public ProductType getType() {
        return this.type;
    }

    public ValueObjectId getId() {
        return this.id;
    }

    public List<Breed> getBreed() {
        return this.breeds;
    }

    public List<DogFoodProduct> getProductsWithSameType(List<DogFoodProduct> products) {
        List<DogFoodProduct> relatedProducts = new ArrayList<DogFoodProduct>();
        for (DogFoodProduct product : products) {
            if (product.getType() == this.type && !this.equals(product)) {
                relatedProducts.add(product);
            }
        }
        return relatedProducts;
    }

    public List<DogFoodProduct> getProductsWithSameBreed(List<DogFoodProduct> products) {
        List<DogFoodProduct> relevantProducts = new ArrayList<DogFoodProduct>();

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

    @Override
    public boolean equals(Object o) {
        DogFoodProduct product = (DogFoodProduct) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
