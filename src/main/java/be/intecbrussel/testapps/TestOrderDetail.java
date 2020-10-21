package be.intecbrussel.testapps;

import be.intecbrussel.data.OrderDaoImp;
import be.intecbrussel.data.OrderDetailsDaoImp;
import be.intecbrussel.data.ProductDaoImp;
import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.Product;

public class TestOrderDetail {

    public static void main(String[] args) {

        OrderDetailsDaoImp orderDetailsDaoApp = new OrderDetailsDaoImp();
        OrderDaoImp orderDaoImp = new OrderDaoImp();
        ProductDaoImp productDaoImp = new ProductDaoImp();

        Order order = orderDaoImp.readOrder(10100);
        Product product = productDaoImp.readProductByCode("S18_1749");
        orderDetailsDaoApp.readOrderDetail(order,product);

    }
}
