package be.intecbrussel.testapps;

import be.intecbrussel.data.OrderDaoImp;
import be.intecbrussel.data.OrderDetailsDaoImp;
import be.intecbrussel.entities.Order;

public class TestOrderDetail {

    public static void main(String[] args) {

        OrderDetailsDaoImp orderDetailsDaoApp = new OrderDetailsDaoImp();
        OrderDaoImp orderDaoImp = new OrderDaoImp();
        Order order = orderDaoImp.readOrder(10329);
        orderDetailsDaoApp.readOrderDetail(order);
    }
}
