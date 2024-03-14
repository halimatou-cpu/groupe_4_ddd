package model;

public class Product {

    private ValueObjectId id;
    private String name;
    private ProductType type;

    public Product(ValueObjectId id, String name, ProductType type){
        this.id = id;
        this.name = name;
        this.type = type;
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
}
