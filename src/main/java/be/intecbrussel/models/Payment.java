package be.intecbrussel.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    private int orderNumber;
    private String checkNumber;
    private LocalDate paymentDate;
    private double amount;

    public Payment() {
    }

    public Payment(int orderNumber, String checkNumber, LocalDate paymentDate, double amount) {
        this.orderNumber = orderNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    @Id
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return orderNumber == payment.orderNumber &&
                Double.compare(payment.amount, amount) == 0 &&
                Objects.equals(checkNumber, payment.checkNumber) &&
                Objects.equals(paymentDate, payment.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, checkNumber, paymentDate, amount);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderNumber=" + orderNumber +
                ", checkNumber='" + checkNumber + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }
}
