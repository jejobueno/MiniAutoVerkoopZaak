package be.intecbrussel.testapps;

import be.intecbrussel.data.OrderDao;
import be.intecbrussel.data.OrderDaoImp;
import be.intecbrussel.entities.Order;
import be.intecbrussel.enums.Status;


public class testOrder {

    public static void main(String[] args) {

        Order order = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        OrderDao orderApp = new OrderDaoImp();

        order = orderApp.readOrder(10401);

        order2.setStatus(order.getStatus());
        order2.setOrderDate(order.getOrderDate());
        order2.setShippedDate(order.getShippedDate());
        order2.setCustomerNumber(order.getCustomerNumber());
        order2.setRequiredDate(order.getRequiredDate());

        //orderApp.deleteOrder(orderApp.readOrder(10426));



    }
}
