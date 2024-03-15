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
        List<Breed> breedListUranium = new ArrayList<Breed>();
        List<Breed> breedListCold = new ArrayList<Breed>();
        List<Breed> breedListRhum = new ArrayList<Breed>();
        List<Breed> breedList = new ArrayList<Breed>();
        List<Breed> breedPrenium = new ArrayList<Breed>();
        List<Breed> breedListFish = new ArrayList<Breed>();


        breedListUranium.add(Breed.CHIHUAHUA);  
        breedListUranium.add(Breed.DACHSHUND);
        breedListUranium.add(Breed.GERMAN_SHEPHERD);
        breedListUranium.add(Breed.LABRADOR_RETRIEVER);


        breedListCold.add(Breed.CHIHUAHUA);
        breedListCold.add(Breed.BULLDOG);   
     
  
        breedListRhum.add(Breed.BULLDOG);
        breedListRhum.add(Breed.DACHSHUND);
        breedListRhum.add(Breed.GERMAN_SHEPHERD);
        breedListRhum.add(Breed.GOLDEN_RETRIEVER);
        breedListRhum.add(Breed.LABRADOR_RETRIEVER);

        breedPrenium.add(Breed.CHIHUAHUA);

        breedList.add(Breed.DACHSHUND);

        breedListFish.add(Breed.LABRADOR_RETRIEVER);

        productList.add(new DogFoodProduct(new ValueObjectId(12), "Croquette pour chien uranium", ProductType.DRYFOOD, breedListUranium));
        productList.add(new DogFoodProduct(new ValueObjectId(13), "Croquette pour chien frois", ProductType.DRYFOOD, breedListCold));
        productList.add(new DogFoodProduct(new ValueObjectId(14), "Croquette pour chien au rhum", ProductType.DRYFOOD, breedListRhum));
        productList.add(new DogFoodProduct(new ValueObjectId(25), "Pâtée premium pour chat", ProductType.EXPENSIVEFOOD, breedPrenium));
        productList.add(new DogFoodProduct(new ValueObjectId(37), "Croquettes économiques pour chien", ProductType.LOWPRICEFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(48), "Boîtes de thon pour chat", ProductType.WETFOOD, breedListFish));

        return productList;
    }

}
