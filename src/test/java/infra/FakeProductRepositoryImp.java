package infra;

import model.Product;
import model.ProductRepository;
import model.ProductType;
import use_case.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeProductRepositoryImp implements ProductRepository {
    @Override
    public Product findProductById(int productId) {
        Product product = this.findAll().stream()
            .filter(p -> p.getId() == productId)
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product(12, "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(13, "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(14, "Croquette pour chat", ProductType.DRYFOOD));
        productList.add(new Product(25, "Pâtée premium pour chat", ProductType.EXPENSIVEFOOD));
        productList.add(new Product(37, "Croquettes économiques pour chien", ProductType.LOWPRICEFOOD));
        productList.add(new Product(48, "Boîtes de thon pour chat", ProductType.WETFOOD));

        return productList;
    }

}
