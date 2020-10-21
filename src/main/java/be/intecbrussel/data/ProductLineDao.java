package be.intecbrussel.data;

import be.intecbrussel.entities.ProductLine;

public interface ProductLineDao {

    void createProductLine(ProductLine productLine);
    ProductLine readProductLine(String productLine);
    void updateProductLine(ProductLine productLine);
    void deleteProductLine(ProductLine productLine);

}
