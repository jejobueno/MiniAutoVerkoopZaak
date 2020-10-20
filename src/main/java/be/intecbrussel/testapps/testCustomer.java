package be.intecbrussel.testapps;

import be.intecbrussel.entities.Customer;
import be.intecbrussel.data.CustomerDaoImp;

public class testCustomer {

    public static void main(String[] args) {

        Customer customer = new Customer();

        CustomerDaoImp customerApp = new CustomerDaoImp();
        customer = customerApp.readCustomer(242);
        System.out.println(customer);
    }


}
