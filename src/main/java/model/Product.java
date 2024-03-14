package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private ValueObjectId id;
    private String name;
    private ProductType type;
    private final List<Breed> breed;

    public Product(ValueObjectId id, String name, ProductType type, List<Breed> breed){
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

    public List<Product> relatedProducts(List<Product> products) {
        List<Product> relatedProducts = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getType() == this.getType() && !product.getId().equals(this.getId())){
                relatedProducts.add(product);
            }
        }
        return relatedProducts;
    }

    @Override
    public boolean equals(Object o) {
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
