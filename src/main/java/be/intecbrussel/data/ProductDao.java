package be.intecbrussel.data;

import be.intecbrussel.entities.Product;

public interface ProductDao {

    void createProduct(Product product);
    Product readProductByCode(String productCode);
    Product readProductByName(String productName);
    void updateProduct(Product product);
    void deleteProduct(Product product);

}
