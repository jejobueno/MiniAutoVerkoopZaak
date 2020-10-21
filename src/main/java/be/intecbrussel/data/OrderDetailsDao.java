package be.intecbrussel.data;

import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.Product;

public interface OrderDetailsDao {

    void createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(Order order);
    void updateOrderDetail(Product product);
    void deleteOrderDetail(OrderDetail orderDetail);

}
