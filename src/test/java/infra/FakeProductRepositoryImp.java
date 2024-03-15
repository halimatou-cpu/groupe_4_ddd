package infra;

import model.Breed;
import model.DogFoodProduct;
import model.ProductRepository;
import model.ProductType;
import model.ValueObjectId;
import use_case.suggestion.NotFoundException;

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

        productList.add(new DogFoodProduct(new ValueObjectId(12), ProductType.DRYFOOD, breedListUranium));
        productList.add(new DogFoodProduct(new ValueObjectId(13), ProductType.DRYFOOD, breedListCold));
        productList.add(new DogFoodProduct(new ValueObjectId(14), ProductType.DRYFOOD, breedListRhum));
        productList.add(new DogFoodProduct(new ValueObjectId(25), ProductType.EXPENSIVEFOOD, breedPrenium));
        productList.add(new DogFoodProduct(new ValueObjectId(37), ProductType.DRYFOOD, breedList));
        productList.add(new DogFoodProduct(new ValueObjectId(48), ProductType.WETFOOD, breedListFish));

        return productList;
    }

}
