package be.intecbrussel.testapps;

import be.intecbrussel.data.CustomerDao;
import be.intecbrussel.data.CustomerDaoImp;
import be.intecbrussel.data.PaymentDao;
import be.intecbrussel.data.PaymentDaoImp;
import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Payment;

import java.time.LocalDate;

public class testPayment {

    public static void main(String[] args) {

        PaymentDao paymentDaoApp = new PaymentDaoImp();
        CustomerDao customerDaoApp = new CustomerDaoImp();

        Payment payment = paymentDaoApp.readPayment("HQ336336");
        Customer customer = customerDaoApp.readCustomer(103);

        //Payment payment1 = new Payment(customer,"HQ00000", LocalDate.of(2004,10,19) ,6000.00);
        Payment payment1 = paymentDaoApp.readPayment("HQ00000");
        //paymentDaoApp.createPayment(payment1);

        paymentDaoApp.deletePayment(payment1);

    }
}
