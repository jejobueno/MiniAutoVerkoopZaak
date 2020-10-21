package be.intecbrussel.testapps;

import be.intecbrussel.data.ProductLineDao;
import be.intecbrussel.data.ProductLineDaoImp;
import be.intecbrussel.entities.ProductLine;

public class TestProductLine {

    public static void main(String[] args) {

        ProductLineDao productLineApp = new ProductLineDaoImp();
        ProductLine productLine = productLineApp.readProductLine("Ships");
    }
}
