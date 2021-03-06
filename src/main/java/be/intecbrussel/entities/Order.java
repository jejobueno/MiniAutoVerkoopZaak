package be.intecbrussel.entities;

import be.intecbrussel.enums.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private Status status;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customerNumber")
    private Customer customerNumber;

    public Order() {
    }

    public Order(LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, Status status, String comments, Customer customerNumber) {
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public int getOderNumber() {
        return orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public Customer getCustomerNumber() {
        return customerNumber;
    }

    public void setOderNumber(int oderNumber) {
        this.orderNumber = oderNumber;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomerNumber(Customer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(requiredDate, order.requiredDate) &&
                Objects.equals(shippedDate, order.shippedDate) &&
                status == order.status &&
                Objects.equals(comments, order.comments) &&
                Objects.equals(customerNumber, order.customerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
    }

    @Override
    public String toString() {
        return "Order{" +
                "oderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", status=" + status +
                ", comments='" + comments + '\'' +
                ", customerNumber=" + customerNumber +
                '}';
    }
}
