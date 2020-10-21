package be.intecbrussel.testapps;

import be.intecbrussel.data.ProductLineDao;
import be.intecbrussel.data.ProductLineDaoImp;
import be.intecbrussel.entities.ProductLine;

public class TestProductLine {

    public static void main(String[] args) {

        ProductLineDao productLineApp = new ProductLineDaoImp();
        ProductLine productLine = productLineApp.readProductLine("Ships");

        ProductLine productLine1 = new ProductLine("Acax","This is a test",null, null);
        productLineApp.createProductLine(productLine1);

        productLine1 = productLineApp.readProductLine("Acax");
        productLineApp.deleteProductLine(productLine1);
    }
}
