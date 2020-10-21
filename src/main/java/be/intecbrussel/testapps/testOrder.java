package be.intecbrussel.testapps;

import be.intecbrussel.data.OrderDaoImp;
import be.intecbrussel.entities.Order;


public class testOrder {

    public static void main(String[] args) {

        Order order = new Order();
        Order order2 = null;
        Order order3 = null;
        OrderDaoImp orderApp = new OrderDaoImp();
        order = orderApp.readOrder(10100);
    }
}
