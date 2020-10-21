package be.intecbrussel.entities;

import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailPK implements Serializable {

    private Product product;
    private Order order;

    public OrderDetailPK(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailPK that = (OrderDetailPK) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}
