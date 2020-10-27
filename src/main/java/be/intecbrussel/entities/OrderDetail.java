package be.intecbrussel.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailPK.class)
public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "orderNumber")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "productCode")
    private Product product;

    private int quantityOrdered;
    private double priceEach;

    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
     private int orderLineNumber;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, int quantityOrdered, double priceEach, int orderLineNumber) {
        this.order = order;
        this.product = product;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product productCode) {
        this.product = productCode;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return quantityOrdered == that.quantityOrdered &&
                Double.compare(that.priceEach, priceEach) == 0 &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product, quantityOrdered, priceEach, orderLineNumber);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderNumber=" + order.getOderNumber() +
                ", productCode=" + product.getProductCode() +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }
}
