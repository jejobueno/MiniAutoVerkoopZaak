package be.intecbrussel.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Order {

    @Id
    private int oderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private Status status;
    private String comments;
    private int customerNumber;

    public Order() {
    }

    public Order(int oderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, Status status, String comments, int customerNumber) {
        this.oderNumber = oderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    @Id
    public int getOderNumber() {
        return oderNumber;
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

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setOderNumber(int oderNumber) {
        this.oderNumber = oderNumber;
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

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerNumber == order.customerNumber &&
                Objects.equals(oderNumber, order.oderNumber) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(requiredDate, order.requiredDate) &&
                Objects.equals(shippedDate, order.shippedDate) &&
                status == order.status &&
                Objects.equals(comments, order.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
    }

    @Override
    public String toString() {
        return "Order{" +
                "oderNumber='" + oderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", status=" + status +
                ", comments='" + comments + '\'' +
                ", customerNumber=" + customerNumber +
                '}';
    }
}
