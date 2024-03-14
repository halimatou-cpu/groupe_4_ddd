package model;

public class Product {

    private int id;
    private String name;
    private ProductType type;

    public Product(int id, String name, ProductType type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public ProductType getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }
}
