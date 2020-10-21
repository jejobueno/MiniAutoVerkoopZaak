package be.intecbrussel.testapps;

import be.intecbrussel.data.*;
import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.Product;

public class TestOrderDetail {

    public static void main(String[] args) {

        OrderDetailsDao orderDetailsDaoApp = new OrderDetailsDaoImp();
        OrderDao orderDaoImp = new OrderDaoImp();
        ProductDao productDaoImp = new ProductDaoImp();

        Order order = orderDaoImp.readOrder(10100);
        Product product = productDaoImp.readProductByCode("S18_1749");
        orderDetailsDaoApp.readOrderDetail(order,product);

    }
}
