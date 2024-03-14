package infra;

import model.Breed;
import model.Product;
import model.ProductRepository;
import model.ProductType;
import model.ValueObjectId;
import use_case.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeProductRepositoryImp implements ProductRepository {
    @Override
    public Product findProductById(ValueObjectId productId) {
        Product product = this.findAll().stream()
            .filter(p -> p.getId().equals(productId))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<Product>();
        List<Breed> breedList = new ArrayList<Breed>();

        breedList.add(Breed.CHIHUAHUA);
        breedList.add(Breed.BULLDOG);   
        breedList.add(Breed.BULLDOG);
        breedList.add(Breed.DACHSHUND);
        breedList.add(Breed.GERMAN_SHEPHERD);
        breedList.add(Breed.GOLDEN_RETRIEVER);
        breedList.add(Breed.LABRADOR_RETRIEVER);

        productList.add(new Product(new ValueObjectId(12), "Croquette pour chat", ProductType.DRYFOOD, breedList));
        productList.add(new Product(new ValueObjectId(13), "Croquette pour chat", ProductType.DRYFOOD, breedList));
        productList.add(new Product(new ValueObjectId(14), "Croquette pour chat", ProductType.DRYFOOD, breedList));
        productList.add(new Product(new ValueObjectId(25), "Pâtée premium pour chat", ProductType.EXPENSIVEFOOD, breedList));
        productList.add(new Product(new ValueObjectId(37), "Croquettes économiques pour chien", ProductType.LOWPRICEFOOD, breedList));
        productList.add(new Product(new ValueObjectId(48), "Boîtes de thon pour chat", ProductType.WETFOOD, breedList));

        return productList;
    }

}
