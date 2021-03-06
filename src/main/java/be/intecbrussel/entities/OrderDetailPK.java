package be.intecbrussel.entities;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailPK implements Serializable {

    private Product product;
    private Order order;

    public OrderDetailPK() {
    }

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

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}
