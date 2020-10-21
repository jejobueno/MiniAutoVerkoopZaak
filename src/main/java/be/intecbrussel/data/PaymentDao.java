package be.intecbrussel.data;

import be.intecbrussel.entities.Payment;

public interface PaymentDao {

    void createPayment(Payment payment);
    Payment readPayment(String checkNumber);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);

}
