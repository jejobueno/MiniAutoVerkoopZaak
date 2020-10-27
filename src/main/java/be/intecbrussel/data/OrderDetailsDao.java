package be.intecbrussel.data;

import be.intecbrussel.entities.Order;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.Product;

import java.util.List;

public interface OrderDetailsDao {

    void createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(Order order,Product product);
    List<OrderDetail> readOrderDetailByOrder(Order order);
    void updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetail orderDetail);

}
