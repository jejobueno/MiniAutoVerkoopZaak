package be.intecbrussel.testapps;

import be.intecbrussel.entities.Customer;
import be.intecbrussel.data.CustomerDaoImp;

public class testCustomer {

    public static void main(String[] args) {

        Customer customer = new Customer();


        CustomerDaoImp customerApp = new CustomerDaoImp();

        customer = customerApp.readCustomer(103);
        customer.setCustomerName("AJDH");
        System.out.println(customer);
        customer.setCustomerNumber(0);
        //customerApp.createCustomer(customer);
        customerApp.deleteCustomer(customer);

    }


}
