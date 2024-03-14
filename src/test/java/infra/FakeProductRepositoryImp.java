package infra;

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

        productList.add(new Product(new ValueObjectId(12), "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(new ValueObjectId(13), "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(new ValueObjectId(14), "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(new ValueObjectId(25), "Pâtée premium pour chat", ProductType.EXPENSIVEFOOD));
        productList.add(new Product(new ValueObjectId(37), "Croquettes économiques pour chien", ProductType.LOWPRICEFOOD));
        productList.add(new Product(new ValueObjectId(48), "Boîtes de thon pour chat", ProductType.WETFOOD));

        return productList;
    }

}
