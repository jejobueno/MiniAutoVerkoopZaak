package be.intecbrussel.testapps;

import be.intecbrussel.data.*;
import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.Product;

public class TestOrderDetail {

    public static void main(String[] args) {

        OrderDetailsDao orderDetailsDaoApp = new OrderDetailsDaoImp();
        OrderDao orderDaoImp = new OrderDaoImp();
        ProductDao productDaoImp = new ProductDaoImp();

        Order order = orderDaoImp.readOrder(10100);
        Product product = productDaoImp.readProductByCode("S700_2824");

        OrderDetail orderDetail = new OrderDetail(order,product,1000,300,102);
        //OrderDetail orderDetail = new OrderDetail();
        //orderDetail.setOrder(order);

        orderDetailsDaoApp.createOrderDetail(orderDetail);
        //orderDetailsDaoApp.readOrderDetailByOrder(order).stream().forEach(System.out::println);



    }
}
