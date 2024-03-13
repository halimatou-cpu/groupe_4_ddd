package infra;

import model.Product;
import model.ProductRepository;
import model.ProductType;

import java.util.ArrayList;
import java.util.List;

public class FakeProductRepositoryImp implements ProductRepository {
    @Override
    public Product findProductById(int productId) {
        return new Product(12, "Croquette pour chat", ProductType.DRYFOOD);
    }

    @Override
    public List<Product> findAll() {
        List productList = new ArrayList<Product>();

        productList.add(new Product(12, "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(25, "Pâtée premium pour chat", ProductType.EXPENSIVEFOOD));
        productList.add(new Product(37, "Croquettes économiques pour chien", ProductType.LOWPRICEFOOD));
        productList.add(new Product(48, "Boîtes de thon pour chat", ProductType.WETFOOD));

        return productList;
    }

}
