package infra;

import model.Breed;
import model.DogFoodProduct;
import model.ProductRepository;
import model.ProductType;
import model.ValueObjectId;
import use_case.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FakeProductRepositoryImp implements ProductRepository {
    @Override
    public DogFoodProduct findProductById(ValueObjectId productId) {
        DogFoodProduct product = this.findAll().stream()
            .filter(p -> p.getId().equals(productId))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));
        return product;
    }

    @Override
    public List<DogFoodProduct> findAll() {
        List<DogFoodProduct> productList = new ArrayList<DogFoodProduct>();
        List<Breed> breedList = new ArrayList<Breed>();

        breedList.add(Breed.CHIHUAHUA);
        breedList.add(Breed.BULLDOG);   
        breedList.add(Breed.BULLDOG);
        breedList.add(Breed.DACHSHUND);
        breedList.add(Breed.GERMAN_SHEPHERD);
        breedList.add(Breed.GOLDEN_RETRIEVER);
        breedList.add(Breed.LABRADOR_RETRIEVER);

        productList.add(new DogFoodProduct(new ValueObjectId(12), "Croquette pour chat", ProductType.DRYFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(13), "Croquette pour chat", ProductType.DRYFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(14), "Croquette pour chat", ProductType.DRYFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(25), "Pâtée premium pour chat", ProductType.EXPENSIVEFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(37), "Croquettes économiques pour chien", ProductType.LOWPRICEFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(48), "Boîtes de thon pour chat", ProductType.WETFOOD, breedList));

        return productList;
    }

}
